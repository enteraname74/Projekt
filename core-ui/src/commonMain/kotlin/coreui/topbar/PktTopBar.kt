package coreui.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coreui.button.PktIconButton
import coreui.spec.IconSpec
import coreui.spec.TopBarAction
import coreui.text.PktText
import coreui.theme.PktTheme
import coreui.theme.UiConst
import coreui.utils.TonalElevation

@Composable
fun PktTopBar(
    modifier: Modifier = Modifier,
    leftAction: TopBarAction? = null,
    rightAction: TopBarAction? = null,
    title: String?,
    tonalElevation: TonalElevation = TonalElevation.None,
    colors: TopBarColors = TopBarColors()
) {
    Surface(
        tonalElevation = tonalElevation.value
    ) {
        Row(
            modifier = modifier
                .background(color = colors.containerColor)
                .fillMaxWidth()
                .padding(UiConst.Spacing.medium),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(UiConst.Spacing.small),
                verticalAlignment = Alignment.CenterVertically
            ) {
                leftAction?.let {
                    PktIconButton(
                        onClick = leftAction.onClick,
                        iconSpec = IconSpec(
                            icon = leftAction.icon,
                            contentDescription = leftAction.contentDescription,
                            size = UiConst.IconSize.medium,
                            tint = colors.contentColor,
                        )
                    )
                }
                title?.let {
                    PktText(
                        text = it,
                        style = PktTheme.typography.h1,
                        color = colors.contentColor,
                    )
                }
            }
            rightAction?.let {
                PktIconButton(
                    onClick = rightAction.onClick,
                    iconSpec = IconSpec(
                        icon = rightAction.icon,
                        contentDescription = rightAction.contentDescription,
                        size = UiConst.IconSize.medium,
                        tint = colors.contentColor,
                    )
                )
            }
        }
    }
}

data class TopBarColors(
    val containerColor: Color = PktTheme.colorScheme.surface,
    val contentColor: Color = PktTheme.colorScheme.onSurface,
)