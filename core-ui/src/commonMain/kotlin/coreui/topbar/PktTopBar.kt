package coreui.topbar

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import coreui.spec.IconSpec
import coreui.spec.TopBarAction
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
        Row {
            leftAction?.let {

            }
        }
    }
}

private class NavigationIconSpec(
    icon: ImageVector,
    contentDescription: String,
    tint: Color,
): IconSpec(
    icon = icon,
    contentDescription = contentDescription,
    size = UiConst.IconSize.medium,
    tint = tint,
)