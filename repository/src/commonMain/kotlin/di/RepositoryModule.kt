package di

import org.koin.dsl.module
import repository.ProjectRepository
import repository.TaskCollectionRepository
import repository.TaskRepository
import repositoryimpl.ProjectRepositoryImpl
import repositoryimpl.TaskCollectionRepositoryImpl
import repositoryimpl.TaskRepositoryImpl

val repositoryModule = module {
    single<ProjectRepository> {
        ProjectRepositoryImpl(
            projectLocalDataSource = get(),
        )
    }
    single<TaskCollectionRepository> {
        TaskCollectionRepositoryImpl(
            taskCollectionLocalDataSource = get(),
        )
    }
    single<TaskRepository> {
        TaskRepositoryImpl(
            taskLocalDataSource = get(),
        )
    }
}