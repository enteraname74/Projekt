package di

import org.koin.dsl.module
import usecase.project.DeleteProjectByIdUseCase
import usecase.project.GetAllProjectsUseCase
import usecase.project.GetProjectByIdUseCase
import usecase.project.UpsertProjectUseCase
import usecase.task.DeleteTaskByIdUseCase
import usecase.task.UpsertTaskUseCase
import usecase.taskcollection.DeleteTaskCollectionByIdUseCase
import usecase.taskcollection.UpsertTaskCollectionUseCase

val useCaseModule = module {
    // Project
    factory { DeleteProjectByIdUseCase(get()) }
    factory { GetAllProjectsUseCase(get()) }
    factory { GetProjectByIdUseCase(get()) }
    factory { UpsertProjectUseCase(get()) }

    // TaskCollection
    factory { UpsertTaskCollectionUseCase(get()) }
    factory { DeleteTaskCollectionByIdUseCase(get()) }

    // Task
    factory { UpsertTaskUseCase(get()) }
    factory { DeleteTaskByIdUseCase(get()) }
}