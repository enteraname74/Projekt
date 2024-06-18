package model

import java.util.UUID

data class TaskCollection(
    val id: UUID,
    val title: String,
    val tasks: List<Task>,
)
