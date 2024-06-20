package usecase.taskcollection

import repository.TaskCollectionRepository
import java.util.UUID

class DeleteTaskCollectionByIdUseCase(
    private val taskCollectionRepository: TaskCollectionRepository,
) {
    suspend operator fun invoke(id: UUID) {
        taskCollectionRepository.deleteById(id)
    }
}