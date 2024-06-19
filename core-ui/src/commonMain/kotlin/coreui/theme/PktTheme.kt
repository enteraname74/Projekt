package coreui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object PktTheme {
    var colorScheme by mutableStateOf(lightScheme)
    val typography = PktTypography
}