package coreui.utils

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class TonalElevation(val value: Dp) {
    None(0.dp),
    Small(4.dp),
    Medium(8.dp),
    High(16.dp),
}

@Composable
fun rememberTopBarElevation(lazyListState: LazyListState): Dp {
    return rememberSaveable {
        if (lazyListState.firstVisibleItemScrollOffset > 0) {
            TonalElevation.Small.value
        } else {
            TonalElevation.None.value
        }
    }
}