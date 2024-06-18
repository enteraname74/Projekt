package di

import org.koin.dsl.module
import usecase.project.DeleteProjectByIdUseCase
import usecase.project.GetAllProjectsUseCase
import usecase.project.GetProjectByIdUseCase
import usecase.project.UpsertProjectUseCase

val useCaseModule = module {
    single { DeleteProjectByIdUseCase(get()) }
    single { GetAllProjectsUseCase(get()) }
    single { GetProjectByIdUseCase(get()) }
    single { UpsertProjectUseCase(get()) }
}