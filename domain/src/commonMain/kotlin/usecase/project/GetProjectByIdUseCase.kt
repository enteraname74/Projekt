package usecase.project

import kotlinx.coroutines.flow.Flow
import model.Project
import java.util.UUID
import repository.ProjectRepository

class GetProjectByIdUseCase(
    private val projectRepository: ProjectRepository,
) {
    operator fun invoke(id: UUID): Flow<Project?> =
        projectRepository.getById(id = id)
}