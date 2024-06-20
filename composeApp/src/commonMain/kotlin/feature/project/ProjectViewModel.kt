package com.github.enteraname74.projekt.feature.project

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import model.Project
import model.Task
import model.TaskCollection
import usecase.project.GetProjectByIdUseCase
import usecase.task.DeleteTaskByIdUseCase
import usecase.task.UpsertTaskUseCase
import usecase.taskcollection.DeleteTaskCollectionByIdUseCase
import usecase.taskcollection.UpsertTaskCollectionUseCase
import java.util.*

class ProjectViewModel(
    private val getProjectByIdUseCase: GetProjectByIdUseCase,
    private val upsertTaskCollectionUseCase: UpsertTaskCollectionUseCase,
    private val deleteTaskCollectionByIdUseCase: DeleteTaskCollectionByIdUseCase,
    private val upsertTaskUseCase: UpsertTaskUseCase,
    private val deleteTaskByIdUseCase: DeleteTaskByIdUseCase,
): ScreenModel {
    private var isModalShown: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private var projectId: MutableStateFlow<UUID?> = MutableStateFlow(null)

    @OptIn(ExperimentalCoroutinesApi::class)
    val projectUiState: StateFlow<ProjectUiState> = projectId.flatMapLatest { id ->
        if (id == null) {
            flowOf(ProjectUiState.Error)
        } else {
            getProjectByIdUseCase(id = id).flatMapLatest { project ->
                if (project == null) {
                    flowOf(ProjectUiState.Error)
                } else {
                    isModalShown.flatMapLatest { isShown ->
                        flowOf(
                            ProjectUiState.Data(
                                project = project,
                                isModalShown = isShown
                            )
                        )
                    }
                }
            }
        }
    }.stateIn(
        scope = screenModelScope,
        started = SharingStarted.Eagerly,
        initialValue = ProjectUiState.Loading
    )

    fun initProjectView(projectId: UUID) {
        this.projectId.value = projectId
    }

    fun upsertTask(task: Task) {
        screenModelScope.launch {
            upsertTaskUseCase(task)
        }
    }

    fun upsertTaskCollection(taskCollection: TaskCollection) {
        screenModelScope.launch {
            upsertTaskCollectionUseCase(taskCollection)
        }
    }

    fun deleteTaskCollection(id: UUID) {
        screenModelScope.launch {
            deleteTaskCollectionByIdUseCase(id)
        }
    }

    fun deleteTask(id: UUID) {
        screenModelScope.launch {
            deleteTaskByIdUseCase(id)
        }
    }
}