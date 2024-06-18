package model

import java.time.LocalDateTime
import java.util.UUID

data class Project(
    val id: UUID,
    val title: String,
    val description: String,
    val collections: List<TaskCollection>,
    val creationDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
)
