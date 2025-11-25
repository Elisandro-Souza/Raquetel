package com.raquetel.app.domain.entities

import java.time.LocalDate
import java.time.LocalTime

data class Booking(
    val id: String,
    val customerId: String,
    val courtId: String,
    val bookingDate: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime,
    val durationHours: Float,
    val totalAmount: Double,
    val status: BookingStatus,
    val checkInTime: Long? = null,  // Timestamp em milliseconds
    val cancellationReason: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
) {
    fun isValid(): Boolean {
        return bookingDate >= LocalDate.now() &&
               startTime < endTime &&
               durationHours > 0 &&
               totalAmount > 0
    }

    fun conflictsWith(other: Booking): Boolean {
        if (this.courtId != other.courtId) return false
        if (this.bookingDate != other.bookingDate) return false
        
        return this.startTime < other.endTime && this.endTime > other.startTime
    }

    fun canCancelWithFullRefund(): Boolean {
        val now = LocalDate.now()
        val hoursUntilBooking = java.time.Duration.between(
            LocalTime.now(),
            startTime
        ).toHours()
        
        return bookingDate > now || 
               (bookingDate == now && hoursUntilBooking >= 24)
    }

    fun canCancelWithPartialRefund(): Boolean {
        val now = LocalDate.now()
        val hoursUntilBooking = java.time.Duration.between(
            LocalTime.now(),
            startTime
        ).toHours()
        
        return bookingDate == now && hoursUntilBooking in 12..23
    }

    fun calculateRefundAmount(): Double {
        return when {
            canCancelWithFullRefund() -> totalAmount
            canCancelWithPartialRefund() -> totalAmount * 0.5
            else -> 0.0
        }
    }

    fun isInPast(): Boolean {
        val now = LocalDate.now()
        return bookingDate < now || 
               (bookingDate == now && endTime < LocalTime.now())
    }

    fun isHappeningNow(): Boolean {
        val now = LocalDate.now()
        val currentTime = LocalTime.now()
        return bookingDate == now && 
               currentTime >= startTime && 
               currentTime <= endTime
    }
}

enum class BookingStatus {
    PENDING,
    CONFIRMED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED,
    NO_SHOW
}
