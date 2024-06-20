package com.github.enteraname74.projekt.feature.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coreui.button.PktIconButton
import coreui.spec.IconSpec
import coreui.text.PktText
import coreui.theme.PktTheme
import coreui.theme.UiConst
import model.Project

@Composable
fun ProjectCard(
    modifier: Modifier = Modifier,
    project: Project,
    onClick: () -> Unit,
    onMoreClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .padding(all = UiConst.Spacing.medium)
                .fillMaxWidth()
                .then(modifier),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PktText(
                text = project.title,
                style = PktTheme.typography.h3,
            )
            PktIconButton(
                onClick = onMoreClick,
                iconSpec = IconSpec(
                    icon = Icons.Rounded.MoreVert,
                    tint = MaterialTheme.colorScheme.onSurface,
                    size = UiConst.IconSize.medium
                )
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxSize(.8f)
                .height(1.dp)
                .background(MaterialTheme.colorScheme.onSurface)
        )
    }
}
