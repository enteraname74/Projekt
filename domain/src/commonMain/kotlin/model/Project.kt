package model

import java.time.LocalDateTime
import java.util.UUID

data class Project(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val collections: List<TaskCollection> = emptyList(),
    val creationDate: LocalDateTime = LocalDateTime.now(),
    val modifiedDate: LocalDateTime = LocalDateTime.now(),
)
