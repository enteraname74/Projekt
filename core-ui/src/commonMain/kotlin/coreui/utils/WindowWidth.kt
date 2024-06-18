package coreui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowWidth(val maxValue: Dp) {
    Compact(maxValue = 600.dp),
    Medium(maxValue = 840.dp),
    Huge(maxValue = Dp.Infinity);

    companion object {
        fun fromWidth(width: Dp): WindowWidth =
            when {
                width <= Compact.maxValue -> Compact
                width <= Medium.maxValue -> Medium
                else -> Huge
            }

    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun rememberWindowWidth(): WindowWidth {
    val density = LocalDensity.current
    val windowWidth = with(density) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }
    return WindowWidth.fromWidth(windowWidth)
}