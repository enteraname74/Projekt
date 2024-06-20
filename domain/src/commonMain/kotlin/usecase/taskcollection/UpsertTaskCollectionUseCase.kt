package usecase.taskcollection

import model.TaskCollection
import repository.TaskCollectionRepository
import repository.TaskRepository

class UpsertTaskCollectionUseCase(
    private val taskCollectionRepository: TaskCollectionRepository,
) {
    suspend operator fun invoke(taskCollection: TaskCollection) {
        taskCollectionRepository.upsert(taskCollection)
    }
}