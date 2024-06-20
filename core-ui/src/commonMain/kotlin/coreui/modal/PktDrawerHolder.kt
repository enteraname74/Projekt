package coreui.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coreui.theme.PktTheme

@Composable
internal fun PktDrawerHolder(
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(.4f)
            .background(color = PktTheme.colorScheme.surface),
    ) {
        content()
    }
}