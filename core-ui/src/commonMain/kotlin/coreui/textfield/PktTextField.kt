package coreui.textfield

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coreui.text.PktText
import coreui.theme.PktTheme
import coreui.theme.UiConst

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PktTextField(
    modifier: Modifier = Modifier,
    textState: TextFieldState,
    singleLine: Boolean = false,
    label: String? = null,
    colors: PktTextFieldColor = PktTextFieldColor(),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(UiConst.Spacing.small)
    ) {
        label?.let {
            PktText(
                text = it,
                style = PktTheme.typography.h2,
            )
        }
        BasicTextField2(
            interactionSource = interactionSource,
            state = textState,
            textStyle = PktTheme.typography.body.copy(color = colors.textColor),
            modifier = Modifier
                .background(color = colors.containerColor)
                .border(
                    width = animateDpAsState(
                        targetValue = if (isFocused) 3.dp else 1.dp,
                        animationSpec = tween(UiConst.AnimationDuration.short)
                    ).value,
                    shape = RoundedCornerShape(4.dp),
                    color = animateColorAsState(
                        targetValue = if (isFocused) colors.borderFocusedColor else colors.borderUnfocusedColor,
                        animationSpec = tween(UiConst.AnimationDuration.short)
                    ).value,
                )
                .padding(UiConst.Spacing.medium)
                .then(modifier),
            lineLimits = if (singleLine) TextFieldLineLimits.SingleLine else TextFieldLineLimits.Default,
            keyboardActions = keyboardActions,
            keyboardOptions = keyboardOptions,
        )
    }
}

data class PktTextFieldColor(
    val containerColor: Color = PktTheme.colorScheme.surface,
    val textColor: Color = PktTheme.colorScheme.onSurface,
    val borderFocusedColor: Color = PktTheme.colorScheme.secondaryContainer,
    val borderUnfocusedColor: Color = PktTheme.colorScheme.onSurface,
)

private val TextFieldDefaultHeight: Dp = 20.dp