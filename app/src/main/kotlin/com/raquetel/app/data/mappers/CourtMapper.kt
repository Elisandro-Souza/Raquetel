package com.raquetel.app.data.mappers

import com.raquetel.app.data.local.entities.CourtEntity
import com.raquetel.app.domain.entities.Court
import com.raquetel.app.domain.entities.CourtType

fun CourtEntity.toDomain(): Court {
    return Court(
        id = id,
        name = name,
        type = CourtType.valueOf(type),
        hourlyRate = hourlyRate,
        isCovered = isCovered,
        isActive = isActive
    )
}

fun Court.toEntity(): CourtEntity {
    return CourtEntity(
        id = id,
        name = name,
        type = type.name,
        hourlyRate = hourlyRate,
        isCovered = isCovered,
        isActive = isActive,
        createdAt = System.currentTimeMillis()
    )
}
