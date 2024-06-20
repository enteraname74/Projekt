package com.github.enteraname74.projekt.feature.home

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import model.Project
import usecase.project.DeleteProjectByIdUseCase
import usecase.project.GetAllProjectsUseCase
import usecase.project.UpsertProjectUseCase
import java.util.*

class HomeViewModel(
    getAllProjectsUseCase: GetAllProjectsUseCase,
    private val deleteProjectByIdUseCase: DeleteProjectByIdUseCase,
    private val upsertProjectUseCase: UpsertProjectUseCase,
) : ScreenModel {
    val projects: StateFlow<List<Project>> = getAllProjectsUseCase()
        .stateIn(
            scope = screenModelScope,
            started = SharingStarted.Eagerly,
            initialValue = emptyList()
        )

    private val _homeUiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    fun deleteProjectById(id: UUID) {
        screenModelScope.launch {
            deleteProjectByIdUseCase(id = id)
        }
    }

    fun upsertProject(project: Project) {
        screenModelScope.launch {
            upsertProjectUseCase(project = project)
            _homeUiState.value = HomeUiState(
                selectedProject = null,
                isProjectManagementModalShown = false,
            )
        }
    }

    fun setProjectManagementModalVisibility(isShown: Boolean) {
        _homeUiState.update {
            it.copy(
                isProjectManagementModalShown = isShown
            )
        }
    }

    fun setSelectedProject(project: Project?) {
        _homeUiState.value = HomeUiState(
            selectedProject = project,
            isProjectManagementModalShown = true,
        )
    }
}