package larsalex.training_app.models

import larsalex.training_app.Routine
import java.time.Duration
import java.time.LocalDateTime

data class History(
        val name: String,
        val duration: Duration,
        val routine: Routine,
        val date: LocalDateTime) {
}