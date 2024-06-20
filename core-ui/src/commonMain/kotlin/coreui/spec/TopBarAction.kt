package coreui.spec

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import coreui.theme.PktTheme
import coreui.theme.UiConst

open class TopBarAction(
    val onClick: () -> Unit,
    val icon: ImageVector,
    val contentDescription: String? = null,
)

class NavigationAction(
    onClick: () -> Unit
): TopBarAction(
    onClick = onClick,
    icon = Icons.AutoMirrored.Rounded.ArrowBack,
    contentDescription = null
)


