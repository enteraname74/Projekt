package com.github.enteraname74.projekt.feature.home.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coreui.button.PktIconButton
import coreui.spec.IconSpec
import coreui.theme.UiConst
import model.Project

@Composable
fun ProjectCard(
    modifier: Modifier = Modifier,
    project: Project,
    onClick: () -> Unit,
    onMoreClick: () -> Unit,
) {

    Row(
        modifier = Modifier
            .clickable { onClick() }
            .padding(all = UiConst.Spacing.medium)
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = project.title,
            color = MaterialTheme.colorScheme.onBackground
        )
        PktIconButton(
            onClick = onMoreClick,
            iconSpec = IconSpec(
                icon = Icons.Rounded.MoreVert,
                tint = MaterialTheme.colorScheme.primary,
                size = UiConst.IconSize.medium
            )
        )
    }
}