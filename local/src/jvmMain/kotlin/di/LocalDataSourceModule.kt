package di

import dao.ProjectDao
import dao.TaskCollectionDao
import dao.TaskDao
import datasource.project.ProjectLocalDataSource
import datasourceimpl.ProjectLocalDataSourceImpl
import org.koin.dsl.module

val localDesktopDataModule = module {

    // Data source
    single<ProjectLocalDataSource> {
        ProjectLocalDataSourceImpl(
            projectDao = get(),
            taskCollectionDao = get(),
            taskDao = get()
        )
    }

    // DAOs
    single { ProjectDao() }
    single { TaskDao() }
    single { TaskCollectionDao() }
}