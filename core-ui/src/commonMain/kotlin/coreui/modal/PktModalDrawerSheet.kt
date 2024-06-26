package coreui.modal

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo

@Composable
internal fun PktModalDrawerSheet(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    drawerContent: @Composable () -> Unit,
    isDrawerShown: Boolean,
    onDismiss: () -> Unit,
) {
    Box(
        modifier = modifier,
    ) {
        content()
        Drawer(
            isShown = isDrawerShown,
            onClose = onDismiss,
        ) {
            drawerContent()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun BoxScope.Drawer(
    isShown: Boolean,
    onClose: () -> Unit,
    content: @Composable () -> Unit
) {
    val closedValue = LocalWindowInfo.current.containerSize.width

    AnimatedVisibility(
        visible = isShown,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        PktScrim(onClose = onClose)
    }
    AnimatedVisibility(
        modifier = Modifier.align(Alignment.TopEnd),
        visible = isShown,
        enter = slideInHorizontally(
            initialOffsetX = { closedValue },
            animationSpec = tween(durationMillis = 300)
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { closedValue },
            animationSpec = tween(durationMillis = 300),
        )
    ) {
        PktDrawerHolder {
            content()
        }
    }
}