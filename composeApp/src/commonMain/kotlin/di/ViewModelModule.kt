package com.github.enteraname74.projekt.di

import com.github.enteraname74.projekt.feature.home.HomeViewModel
import com.github.enteraname74.projekt.feature.project.ProjectViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory {
        HomeViewModel(
            getAllProjectsUseCase = get(),
            deleteProjectByIdUseCase = get(),
            upsertProjectUseCase = get(),
        )
    }
    factory {
        ProjectViewModel(
            getProjectByIdUseCase = get(),
            upsertTaskCollectionUseCase = get(),
            upsertTaskUseCase = get(),
            deleteTaskByIdUseCase = get(),
            deleteTaskCollectionByIdUseCase = get(),
        )
    }
}