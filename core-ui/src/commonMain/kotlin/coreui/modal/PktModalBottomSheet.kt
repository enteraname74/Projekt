package coreui.modal

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo

@Composable
internal fun PktModalBottomSheet(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    sheetContent: @Composable () -> Unit,
    isSheetShown: Boolean,
    onDismiss: () -> Unit,
) {
    Box(
        modifier = modifier
    ) {
        content()
        BottomSheet(
            isShown = isSheetShown,
            onClose = onDismiss
        ) {
            sheetContent()
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun BoxScope.BottomSheet(
    isShown: Boolean,
    onClose: () -> Unit,
    content: @Composable () -> Unit
) {
    val closedValue = LocalWindowInfo.current.containerSize.height

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
        enter = slideInVertically(
            initialOffsetY = { closedValue },
            animationSpec = tween(durationMillis = 300)
        ),
        exit = slideOutVertically(
            targetOffsetY = { closedValue },
            animationSpec = tween(durationMillis = 300),
        )
    ) {
        PktBottomSheetHolder {
            content()
        }
    }
}