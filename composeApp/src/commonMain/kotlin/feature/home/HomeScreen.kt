package com.github.enteraname74.projekt.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.github.enteraname74.projekt.feature.home.composable.ProjectManagement
import com.github.enteraname74.projekt.feature.home.composable.ProjectList
import com.github.enteraname74.projekt.feature.project.ProjectScreen
import coreui.button.FloatingIconSpec
import coreui.button.PktFloatingButton
import coreui.modal.PktModalScreen
import coreui.theme.PktTheme
import coreui.theme.UiConst
import coreui.topbar.TopBarColors
import coreui.topbar.PktTopBar
import model.Project
import org.jetbrains.compose.resources.stringResource
import projekt.composeapp.generated.resources.Res
import projekt.composeapp.generated.resources.app_name
import java.util.*

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel: HomeViewModel = koinScreenModel()
        val homeUiState: HomeUiState by screenModel.homeUiState.collectAsState()
        val projects: List<Project> by screenModel.projects.collectAsState()

        val navigator = LocalNavigator.currentOrThrow

        HomeView(
            homeUiState = homeUiState,
            projects = projects,
            onProjectClicked = { projectId ->
                navigator.push(
                    ProjectScreen(projectId = projectId)
                )
            },
            onUpsertProject = screenModel::upsertProject,
            onDeleteProject = screenModel::deleteProjectById,
            onProjectSelected = screenModel::setSelectedProject,
            onCreateProjectClicked = { screenModel.setSelectedProject(project = null) },
            setProjectModalVisibility = screenModel::setProjectManagementModalVisibility
        )
    }
}

@Composable
private fun HomeView(
    homeUiState: HomeUiState,
    projects: List<Project>,
    onProjectClicked: (projectId: UUID) -> Unit,
    onProjectSelected: (project: Project) -> Unit,
    onDeleteProject: (projectId: UUID) -> Unit,
    onUpsertProject: (project: Project) -> Unit,
    setProjectModalVisibility: (isShown: Boolean) -> Unit,
    onCreateProjectClicked: () -> Unit,
) {
    PktModalScreen(
        isModalShown = homeUiState.isProjectManagementModalShown,
        onModalDismiss = { setProjectModalVisibility(false) },
        content = {
            HomeViewContent(
                onProjectClicked = onProjectClicked,
                onCreateProjectClicked = onCreateProjectClicked,
                onMoreClicked = onProjectSelected,
                projects = projects,
            )
        },
        modalContent = {
            ProjectManagement(
                onDismiss = { setProjectModalVisibility(false) },
                onValidate = onUpsertProject,
                project = homeUiState.selectedProject,
                onDelete = onDeleteProject,
            )
        }
    )

}

@Composable
private fun HomeViewContent(
    projects: List<Project>,
    onProjectClicked: (projectId: UUID) -> Unit,
    onMoreClicked: (project: Project) -> Unit,
    onCreateProjectClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        PktTopBar(
            title = stringResource(Res.string.app_name),
            colors = TopBarColors(
                containerColor = PktTheme.colorScheme.surfaceContainer,
                contentColor = PktTheme.colorScheme.onSurface,
            )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = UiConst.Spacing.medium),
        ) {
            ProjectList(
                projects = projects,
                onProjectClicked = onProjectClicked,
                onMoreClicked = onMoreClicked,
            )
            PktFloatingButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(
                        end = UiConst.Spacing.medium,
                        bottom = UiConst.Spacing.medium,
                    ),
                onClick = onCreateProjectClicked,
                iconSpec = FloatingIconSpec(
                    icon = Icons.Rounded.Add,
                )
            )
        }
    }
}