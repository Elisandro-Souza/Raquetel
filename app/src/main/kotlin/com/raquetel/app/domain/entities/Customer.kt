package com.raquetel.app.domain.entities

import java.time.LocalDate

data class Customer(
    val id: String,
    val name: String,
    val cpf: String,
    val phone: String,
    val email: String?,
    val birthDate: LocalDate?,
    val address: String?,
    val skillLevel: SkillLevel,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    fun isValid(): Boolean {
        return name.isNotBlank() &&
               cpf.length == 11 &&
               phone.isNotBlank() &&
               (email == null || email.contains("@"))
    }

    fun getShortName(): String {
        val parts = name.trim().split(" ")
        return if (parts.size > 1) {
            "${parts.first()} ${parts.last()}"
        } else {
            name
        }
    }

    fun getAge(): Int? {
        return birthDate?.let {
            java.time.Period.between(it, LocalDate.now()).years
        }
    }

    fun getFormattedCpf(): String {
        return cpf.replace(
            Regex("(\\d{3})(\\d{3})(\\d{3})(\\d{2})"),
            "$1.$2.$3-$4"
        )
    }

    fun getFormattedPhone(): String {
        return phone.replace(
            Regex("(\\d{2})(\\d{5})(\\d{4})"),
            "($1) $2-$3"
        )
    }
}

enum class SkillLevel(val displayName: String) {
    BEGINNER("Iniciante"),
    INTERMEDIATE("Intermediário"),
    ADVANCED("Avançado")
}
