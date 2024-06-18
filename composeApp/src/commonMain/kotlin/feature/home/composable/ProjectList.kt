package com.github.enteraname74.projekt.feature.home.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import model.Project
import java.util.*

@Composable
fun ProjectList(
    projects: List<Project>,
    onProjectClicked: (id: UUID) -> Unit,
) {
    LazyColumn {
        items(items = projects) { project ->
            ProjectCard(
                project = project,
                onClick = { onProjectClicked(project.id) },
                onMoreClick = {}
            )
        }
    }
}