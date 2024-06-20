package com.github.enteraname74.projekt.feature.project.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coreui.theme.UiConst
import model.Task
import model.TaskCollection
import java.util.*

@Composable
fun TaskCollectionView(
    projectId: UUID,
    taskCollections: List<TaskCollection>,
    upsertTaskCollection: (TaskCollection) -> Unit,
    onTaskClicked: (task: Task) -> Unit,
    onDeleteTaskCollection: (taskCollectionId: UUID) -> Unit,
) {
    LazyRow(
        modifier = Modifier.padding(UiConst.Spacing.medium),
        horizontalArrangement = Arrangement.spacedBy(UiConst.Spacing.medium),
    ) {
        items(items = taskCollections) { taskCollection ->
            TaskCollectionCard(
                taskCollection = taskCollection,
                onTaskClicked = onTaskClicked,
                onDeleteClick = { onDeleteTaskCollection(taskCollection.id) },
                onEditTitle = { newTitle ->
                    upsertTaskCollection(taskCollection.copy(title = newTitle))
                }
            )
        }
        item {
            NewTaskCollectionButton(
                onNewTaskClicked = {
                    upsertTaskCollection(
                        TaskCollection(projectId = projectId)
                    )
                }
            )
        }
    }
}