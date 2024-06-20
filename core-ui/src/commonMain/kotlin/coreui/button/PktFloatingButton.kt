package coreui.button

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import coreui.spec.IconSpec
import coreui.theme.PktTheme
import coreui.theme.UiConst
import projekt.core_ui.generated.resources.Res

@Composable
fun PktFloatingButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    iconSpec: IconSpec,
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = onClick,
        shape = CircleShape,
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
    ) {
        Icon(
            modifier = Modifier
                .size(iconSpec.size),
            imageVector = iconSpec.icon,
            contentDescription = iconSpec.contentDescription,
            tint = iconSpec.tint,
        )
    }
}

class FloatingIconSpec(
    icon: ImageVector,
    contentDescription: String? = null,
    size: Dp = UiConst.IconSize.large,
    tint: Color = PktTheme.colorScheme.onPrimaryContainer,
) : IconSpec(
    icon = icon,
    contentDescription = contentDescription,
    size = size,
    tint = tint,
)