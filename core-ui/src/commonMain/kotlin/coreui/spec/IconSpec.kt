package coreui.spec

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp

open class IconSpec(
    val icon: ImageVector,
    val size: Dp,
    val tint: Color,
    val contentDescription: String? = null,
)
