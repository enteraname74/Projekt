package coreui.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coreui.button.PktIconButton
import coreui.spec.TopBarAction
import coreui.spec.toIconSpec
import coreui.theme.UiConst
import coreui.utils.TonalElevation

@Composable
fun PktTopBar(
    leftAction: TopBarAction? = null,
    rightAction: TopBarAction? = null,
    title: String?,
    tonalElevation: TonalElevation = TonalElevation.None
) {
    Surface(
        tonalElevation = tonalElevation.value
    ) {
        Row(
            modifier = Modifier
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
                        iconSpec = leftAction.toIconSpec()
                    )
                }
                title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.headlineMedium,
                    )
                }
            }
            rightAction?.let {
                PktIconButton(
                    onClick = rightAction.onClick,
                    iconSpec = rightAction.toIconSpec()
                )
            }
        }
    }
}