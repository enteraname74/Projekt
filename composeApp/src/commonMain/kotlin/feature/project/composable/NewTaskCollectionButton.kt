package com.github.enteraname74.projekt.feature.project.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coreui.icon.PktIcon
import coreui.spec.IconSpec
import coreui.text.PktText
import coreui.theme.PktTheme
import coreui.theme.UiConst
import org.jetbrains.compose.resources.stringResource
import projekt.composeapp.generated.resources.Res
import projekt.composeapp.generated.resources.projectPage_newColumn

@Composable
fun NewTaskCollectionButton(
    modifier: Modifier = Modifier,
    onNewTaskClicked: () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                onNewTaskClicked()
            }
            .padding(UiConst.Spacing.medium),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        PktIcon(
            iconSpec = IconSpec(
                icon = Icons.Default.Add,
                tint = PktTheme.colorScheme.secondary,
                size = UiConst.IconSize.large,
            )
        )
        PktText(
            text = stringResource(Res.string.projectPage_newColumn),
            style = PktTheme.typography.h2,
            color = PktTheme.colorScheme.secondary
        )
    }
}