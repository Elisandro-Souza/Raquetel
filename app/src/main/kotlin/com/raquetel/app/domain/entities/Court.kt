package com.raquetel.app.domain.entities

import java.time.LocalTime

data class Court(
    val id: String,
    val name: String,
    val type: CourtType,
    val hourlyRate: Double,
    val isCovered: Boolean,
    val isActive: Boolean = true,
    val operatingHoursStart: LocalTime = LocalTime.of(6, 0),
    val operatingHoursEnd: LocalTime = LocalTime.of(23, 0),
    val createdAt: Long = System.currentTimeMillis()
) {
    fun isAvailableAt(time: LocalTime): Boolean {
        return isActive && time >= operatingHoursStart && time <= operatingHoursEnd
    }

    fun calculateAmount(durationHours: Float): Double {
        return hourlyRate * durationHours
    }

    fun getDescription(): String {
        val coverageText = if (isCovered) "Coberta" else "Descoberta"
        return "$name - $coverageText - ${type.displayName}"
    }

    fun isOpenNow(): Boolean {
        val now = LocalTime.now()
        return isActive && isAvailableAt(now)
    }
}

enum class CourtType(val displayName: String) {
    STANDARD("Padrão"),
    PROFESSIONAL("Profissional"),
    TRAINING("Treino")
}
