package di

import org.koin.dsl.module
import repository.ProjectRepository
import repositoryimpl.ProjectRepositoryImpl

val repositoryModule = module {
    single<ProjectRepository> {
        ProjectRepositoryImpl(
            projectLocalDataSource = get()
        )
    }
}