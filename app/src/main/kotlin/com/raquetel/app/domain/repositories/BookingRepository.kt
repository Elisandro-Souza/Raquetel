package com.raquetel.app.domain.repositories

import com.raquetel.app.core.util.Result
import com.raquetel.app.domain.entities.Booking
import com.raquetel.app.domain.entities.BookingStatus
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface BookingRepository {
    
    fun getAll(): Flow<List<Booking>>
    
    suspend fun getById(id: String): Result<Booking>
    
    fun getByCustomerId(customerId: String): Flow<List<Booking>>
    
    fun getByCourtId(courtId: String): Flow<List<Booking>>
    
    suspend fun getByDate(date: LocalDate): Result<List<Booking>>
    
    suspend fun getByCourtAndDate(courtId: String, date: LocalDate): Result<List<Booking>>
    
    suspend fun save(booking: Booking): Result<Booking>
    
    suspend fun updateStatus(bookingId: String, status: BookingStatus): Result<Unit>
    
    suspend fun cancel(bookingId: String, reason: String): Result<Unit>
    
    suspend fun delete(id: String): Result<Unit>
    
    suspend fun hasConflict(booking: Booking): Result<Boolean>
}
