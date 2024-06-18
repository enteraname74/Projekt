package com.github.enteraname74.projekt.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.github.enteraname74.projekt.feature.home.composable.ProjectCreation
import com.github.enteraname74.projekt.feature.home.composable.ProjectList
import coreui.button.FloatingIconSpec
import coreui.button.PktFloatingButton
import coreui.modal.PktModalHolder
import coreui.theme.UiConst
import java.util.*

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = koinScreenModel<HomeViewModel>()
        val homeUiState: HomeUiState by screenModel.homeUiState.collectAsState()

        HomeView(
            homeUiState = homeUiState,
            onProjectClicked = screenModel::deleteProjectById,
            onOpenProjectCreationView = screenModel::addProject
        )
    }

}

@Composable
private fun HomeView(
    homeUiState: HomeUiState,
    onProjectClicked: (projectId: UUID) -> Unit,
    onOpenProjectCreationView: () -> Unit,
) {
    var isModalShown by rememberSaveable {
        mutableStateOf(false)
    }

    PktModalHolder(
        isModalShown = isModalShown,
        onModalDismiss = { isModalShown = false },
        content = {
            HomeViewContent(
                homeUiState = homeUiState,
                onProjectClicked = onProjectClicked,
                onOpenProjectCreationView = { isModalShown = true }
            )
        },
        modalContent = {
            ProjectCreation(
                onDismiss = { isModalShown = false },
                onValidate = {},
                onSetTitle = {},
                onSetDescription = {},
            )
        }
    )

}

@Composable
private fun HomeViewContent(
    homeUiState: HomeUiState,
    onProjectClicked: (projectId: UUID) -> Unit,
    onOpenProjectCreationView: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ProjectList(
            projects = homeUiState.projects,
            onProjectClicked = onProjectClicked,
        )
        PktFloatingButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(
                    end = UiConst.Spacing.medium,
                    bottom = UiConst.Spacing.medium,
                ),
            onClick = onOpenProjectCreationView,
            iconSpec = FloatingIconSpec(
                icon = Icons.Rounded.Add,
                tint = MaterialTheme.colorScheme.onSecondary
            )
        )
    }
}