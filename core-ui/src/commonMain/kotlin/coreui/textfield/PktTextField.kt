package coreui.textfield

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coreui.theme.UiConst

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PktTextField(
    modifier: Modifier = Modifier,
    textState: TextFieldState,
    singleLine: Boolean = false,
    label: String? = null,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(UiConst.Spacing.small)
    ) {
        label?.let {
            Text(text = it)
        }
        BasicTextField2(
            state = textState,
            modifier = modifier.border(
                width = 1.dp,
                shape = RoundedCornerShape(4.dp),
                color = MaterialTheme.colorScheme.secondaryContainer,
            ),
            lineLimits = if (singleLine) TextFieldLineLimits.SingleLine else TextFieldLineLimits.Default,
        )
    }

}