package coreui.icon

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coreui.spec.IconSpec

@Composable
fun PktIcon(
    iconSpec: IconSpec,
) {
    Icon(
        modifier = Modifier.size(iconSpec.size),
        imageVector = iconSpec.icon,
        contentDescription = iconSpec.contentDescription,
        tint = iconSpec.tint,
    )
}