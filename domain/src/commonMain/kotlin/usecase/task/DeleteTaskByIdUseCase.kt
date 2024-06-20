package usecase.task

import repository.TaskRepository
import java.util.UUID

class DeleteTaskByIdUseCase(
    private val taskRepository: TaskRepository,
) {
    suspend operator fun invoke(id: UUID) {
        taskRepository.deleteById(id)
    }
}