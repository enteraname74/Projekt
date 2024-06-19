package coreui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object PktTypography {
    val h1 = TextStyle(
        color = PktTheme.colorScheme.onSurface,
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold,
    )

    val h2 = TextStyle(
        color = PktTheme.colorScheme.onSurface,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
    )

    val h3 = TextStyle(
        color = PktTheme.colorScheme.onSurface,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
    )

    val body = TextStyle(
        color = PktTheme.colorScheme.onSurface,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
    )
}