package coreui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import coreui.theme.PktTheme

@Composable
fun PktText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = PktTheme.typography.body,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign? = null,
    color: Color = PktTheme.colorScheme.onSurface,
) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        overflow = overflow,
        textAlign = textAlign,
        maxLines = maxLines,
        color = color,
    )
}