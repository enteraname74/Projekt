package usecase.task

import model.Task
import repository.TaskRepository

class UpsertTaskUseCase(
    private val taskRepository: TaskRepository,
) {
    suspend operator fun invoke(task: Task) {
        taskRepository.upsert(task)
    }
}