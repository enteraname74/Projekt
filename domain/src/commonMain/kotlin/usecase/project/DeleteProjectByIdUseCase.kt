package usecase.project

import repository.ProjectRepository
import java.util.UUID

class DeleteProjectByIdUseCase(
    private val projectRepository: ProjectRepository,
) {
    suspend operator fun invoke(id: UUID) {
        projectRepository.deleteById(id = id)
    }
}