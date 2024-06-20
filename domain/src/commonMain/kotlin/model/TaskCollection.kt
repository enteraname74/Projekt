package model

import java.util.UUID

data class TaskCollection(
    val id: UUID = UUID.randomUUID(),
    val projectId: UUID,
    val title: String = "",
    val tasks: List<Task> = emptyList(),
)
