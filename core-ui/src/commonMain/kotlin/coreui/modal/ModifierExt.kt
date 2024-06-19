package coreui.modal

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics

/**
 * Disable the focus and click action on a composable.
 */
internal fun Modifier.disableFocus() = this
    .pointerInput(Unit) { detectTapGestures {  } }
    .semantics(mergeDescendants = true) {
        contentDescription = ""
        onClick { true }
    }
    .onKeyEvent { true }