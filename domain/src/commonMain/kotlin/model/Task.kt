package model

import java.time.LocalDateTime
import java.util.UUID

data class Task(
    val id: UUID,
    val title: String,
    val description: String,
    val weight: String,
    val creationDate: LocalDateTime,
    val modifiedDate: LocalDateTime,
)
