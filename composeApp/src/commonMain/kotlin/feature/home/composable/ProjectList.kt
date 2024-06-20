package com.github.enteraname74.projekt.feature.home.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import model.Project
import java.util.*

@Composable
fun ProjectList(
    projects: List<Project>,
    onProjectClicked: (id: UUID) -> Unit,
    onMoreClicked: (project: Project) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(.8f)
                .align(Alignment.TopCenter)
        ) {
            items(items = projects) { project ->
                ProjectCard(
                    project = project,
                    onClick = { onProjectClicked(project.id) },
                    onMoreClick = { onMoreClicked(project) }
                )
            }
        }
    }
}