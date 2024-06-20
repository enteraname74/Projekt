package di

import dao.ProjectDao
import dao.TaskCollectionDao
import dao.TaskDao
import datasource.project.ProjectLocalDataSource
import datasource.task.TaskLocalDataSource
import datasource.taskcollection.TaskCollectionLocalDataSource
import datasourceimpl.ProjectLocalDataSourceImpl
import datasourceimpl.TaskCollectionLocalDataSourceImpl
import datasourceimpl.TaskLocalDataSourceImpl
import org.koin.dsl.module

val localDesktopDataModule = module {

    // Data source
    single<ProjectLocalDataSource> {
        ProjectLocalDataSourceImpl(
            projectDao = get(),
            taskCollectionDao = get(),
            taskDao = get(),
        )
    }
    single<TaskCollectionLocalDataSource> {
        TaskCollectionLocalDataSourceImpl(
            taskCollectionDao = get(),
        )
    }
    single<TaskLocalDataSource> {
        TaskLocalDataSourceImpl(
            taskDao = get(),
        )
    }

    // DAOs
    single { ProjectDao() }
    single { TaskDao() }
    single { TaskCollectionDao() }
}