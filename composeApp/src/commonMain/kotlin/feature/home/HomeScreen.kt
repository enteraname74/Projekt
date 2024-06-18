package com.github.enteraname74.projekt.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import com.github.enteraname74.projekt.feature.home.composable.ProjectList
import coreui.button.FloatingIconSpec
import coreui.button.PktFloatingButton
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
fun HomeView(
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
                .align(Alignment.BottomEnd),
            onClick = onOpenProjectCreationView,
            iconSpec = FloatingIconSpec(
                icon = Icons.Rounded.Add,
                tint = MaterialTheme.colorScheme.onSecondary
            )
        )
    }
}