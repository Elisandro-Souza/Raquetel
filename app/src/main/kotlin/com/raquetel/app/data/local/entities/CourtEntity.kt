package com.raquetel.app.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "courts")
data class CourtEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val type: String,
    val hourlyRate: Double,
    val isCovered: Boolean,
    val isActive: Boolean,
    val createdAt: Long = System.currentTimeMillis()
)
