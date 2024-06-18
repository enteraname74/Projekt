package coreui.modal

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coreui.utils.WindowWidth
import coreui.utils.rememberWindowWidth

@Composable
fun PktModalHolder(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    modalContent: @Composable () -> Unit,
    isModalShown: Boolean,
    onModalDismiss: () -> Unit,
) {
    val windowWidth = rememberWindowWidth()

    if (windowWidth <= WindowWidth.Medium) {
        PktModalBottomSheet(
            modifier = modifier,
            content = content,
            sheetContent = modalContent,
            isSheetShown = isModalShown,
            onDismiss = onModalDismiss
        )
    } else {
        PktModalDrawerSheet(
            modifier = modifier,
            content = content,
            drawerContent = modalContent,
            isDrawerShown = isModalShown,
            onDismiss = onModalDismiss
        )
    }
}