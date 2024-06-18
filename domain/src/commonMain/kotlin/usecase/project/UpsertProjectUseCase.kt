package usecase.project

import model.Project
import repository.ProjectRepository

class UpsertProjectUseCase(
    private val projectRepository: ProjectRepository,
) {
    suspend operator fun invoke(project: Project) {
        projectRepository.upsert(
            project = project,
        )
    }
}