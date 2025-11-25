package com.raquetel.app.data.mappers

import com.raquetel.app.data.local.entities.BookingEntity
import com.raquetel.app.domain.entities.Booking
import com.raquetel.app.domain.entities.BookingStatus

fun BookingEntity.toDomain(): Booking {
    return Booking(
        id = id,
        customerId = customerId,
        courtId = courtId,
        bookingDate = bookingDate,
        startTime = startTime,
        endTime = endTime,
        durationHours = durationHours,
        totalAmount = totalAmount,
        status = BookingStatus.valueOf(status),
        checkInTime = checkInTime,
        cancellationReason = cancellationReason
    )
}

fun Booking.toEntity(): BookingEntity {
    return BookingEntity(
        id = id,
        customerId = customerId,
        courtId = courtId,
        bookingDate = bookingDate,
        startTime = startTime,
        endTime = endTime,
        durationHours = durationHours,
        totalAmount = totalAmount,
        status = status.name,
        checkInTime = checkInTime,
        cancellationReason = cancellationReason,
        createdAt = System.currentTimeMillis(),
        updatedAt = System.currentTimeMillis()
    )
}
