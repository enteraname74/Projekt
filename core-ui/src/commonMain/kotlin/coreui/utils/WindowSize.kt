package coreui.utils

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class WindowSize(maxValue: Dp) {
    Compact(maxValue = 600.dp),
    Medium(maxValue = 840.dp),
    Expanded(maxValue = Dp.Infinity)
}