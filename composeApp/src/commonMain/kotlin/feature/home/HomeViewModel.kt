package com.github.enteraname74.projekt.feature.home

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import model.Project
import usecase.project.DeleteProjectByIdUseCase
import usecase.project.GetAllProjectsUseCase
import usecase.project.UpsertProjectUseCase
import java.time.LocalDateTime
import java.util.UUID

class HomeViewModel(
    getAllProjectsUseCase: GetAllProjectsUseCase,
    private val deleteProjectByIdUseCase: DeleteProjectByIdUseCase,
    private val upsertProjectUseCase: UpsertProjectUseCase,
) : ScreenModel {
    @OptIn(ExperimentalCoroutinesApi::class)
    val homeUiState: StateFlow<HomeUiState> = getAllProjectsUseCase().flatMapLatest { projects ->
        flowOf(
            HomeUiState(
                projects = projects
            )
        )
    }.stateIn(
        scope = screenModelScope,
        started = SharingStarted.Eagerly,
        initialValue = HomeUiState()
    )

    fun deleteProjectById(id: UUID) {
        screenModelScope.launch {
            deleteProjectByIdUseCase(id = id)
        }
    }

    fun addProject() {
        screenModelScope.launch {
            val project = Project(
                id = UUID.randomUUID(),
                title = "test",
                description = "desc",
                collections = emptyList(),
                creationDate = LocalDateTime.now(),
                modifiedDate = LocalDateTime.now(),
            )

            upsertProjectUseCase(project = project)
        }
    }
}