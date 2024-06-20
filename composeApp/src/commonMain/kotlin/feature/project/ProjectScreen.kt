package com.github.enteraname74.projekt.feature.project

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.github.enteraname74.projekt.feature.project.composable.TaskCollectionView
import coreui.screen.PktScreen
import coreui.spec.NavigationAction
import coreui.theme.UiConst
import coreui.topbar.PktTopBar
import model.Task
import model.TaskCollection
import java.util.UUID

class ProjectScreen(private val projectId: UUID): Screen {
    @Composable
    override fun Content() {
        val screenModel: ProjectViewModel = koinScreenModel()
        val projectUiState: ProjectUiState by screenModel.projectUiState.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        LaunchedEffect(Unit) {
            screenModel.initProjectView(projectId = projectId)
        }

        if (projectUiState is ProjectUiState.Data) {
            ProjectView(
                projectUiState = projectUiState as ProjectUiState.Data,
                upsertTaskCollection = screenModel::upsertTaskCollection,
                onTaskClicked = {},
                onDeleteTaskCollection = screenModel::deleteTaskCollection,
                navigateBack = { navigator.pop() }
            )
        } else {
            PktScreen {

            }
        }
    }
}

@Composable
private fun ProjectView(
    projectUiState: ProjectUiState.Data,
    upsertTaskCollection: (taskCollection: TaskCollection) -> Unit,
    onTaskClicked: (Task) -> Unit,
    onDeleteTaskCollection: (taskCollectionId: UUID) -> Unit,
    navigateBack: () -> Unit,
) {
    PktScreen {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(UiConst.Spacing.medium)
        ) {
            PktTopBar(
                leftAction = NavigationAction(
                    onClick = navigateBack
                ),
                title = projectUiState.project.title,
            )
            TaskCollectionView(
                projectId = projectUiState.project.id,
                taskCollections = projectUiState.project.collections,
                upsertTaskCollection = upsertTaskCollection,
                onTaskClicked = onTaskClicked,
                onDeleteTaskCollection = onDeleteTaskCollection,
            )
        }
    }
}