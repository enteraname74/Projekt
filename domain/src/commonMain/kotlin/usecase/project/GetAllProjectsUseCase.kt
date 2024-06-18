package usecase.project

import kotlinx.coroutines.flow.Flow
import model.Project
import repository.ProjectRepository

class GetAllProjectsUseCase(
    private val projectRepository: ProjectRepository,
) {
    operator fun invoke(): Flow<List<Project>> =
        projectRepository.getAll()
}