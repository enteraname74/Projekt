package coreui.button

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coreui.spec.IconSpec

@Composable
fun PktIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    iconSpec: IconSpec,
) {
    IconButton(
        onClick = onClick,
        enabled = enabled,
    ) {
        Icon(
            modifier = Modifier
                .size(iconSpec.size)
                .then(modifier),
            imageVector = iconSpec.icon,
            contentDescription = iconSpec.contentDescription,
            tint = iconSpec.tint
        )
    }
}