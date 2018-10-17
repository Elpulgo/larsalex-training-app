package larsalex.training_app.models

import java.time.LocalDateTime

data class Session(
        val id: Int,
        val exerciseId: Int,
        val start: LocalDateTime,
        val end: LocalDateTime

)