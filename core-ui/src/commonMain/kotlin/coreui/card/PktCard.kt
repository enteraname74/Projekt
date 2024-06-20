package coreui.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coreui.text.PktText
import coreui.theme.PktTheme

@Composable
fun PktCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    colors: PktCardColors = PktCardColors(),
    content: @Composable (ColumnScope.() -> Unit),
) {
    val clickableModifier = if (onClick != null) {
        Modifier.clickable(onClick = onClick)
    } else {
        Modifier
    }

    Card(
        modifier = clickableModifier.then(modifier),
        colors = CardDefaults.cardColors(
            containerColor = colors.containerColor,
            contentColor = colors.containerColor,
        ),
    ) {
        content()
    }
}

data class PktCardColors(
    val containerColor: Color = PktTheme.colorScheme.primaryContainer,
    val contentColor: Color = PktTheme.colorScheme.onPrimaryContainer,
)