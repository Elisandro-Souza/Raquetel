package com.raquetel.app.data.local.dao

import androidx.room.*
import com.raquetel.app.data.local.entities.BookingEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

@Dao
interface BookingDao {
    
    @Query("SELECT * FROM bookings ORDER BY bookingDate DESC, startTime DESC")
    fun getAllBookings(): Flow<List<BookingEntity>>
    
    @Query("SELECT * FROM bookings WHERE id = :bookingId")
    suspend fun getBookingById(bookingId: String): BookingEntity?
    
    @Query("SELECT * FROM bookings WHERE customerId = :customerId ORDER BY bookingDate DESC")
    fun getBookingsByCustomer(customerId: String): Flow<List<BookingEntity>>
    
    @Query("SELECT * FROM bookings WHERE courtId = :courtId AND bookingDate = :date ORDER BY startTime ASC")
    fun getBookingsByCourtAndDate(courtId: String, date: LocalDate): Flow<List<BookingEntity>>
    
    @Query("SELECT * FROM bookings WHERE status IN (:statuses) ORDER BY bookingDate DESC")
    fun getBookingsByStatus(statuses: List<String>): Flow<List<BookingEntity>>
    
    @Query("SELECT * FROM bookings WHERE bookingDate BETWEEN :startDate AND :endDate ORDER BY bookingDate DESC")
    fun getBookingsByDateRange(startDate: LocalDate, endDate: LocalDate): Flow<List<BookingEntity>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooking(booking: BookingEntity)
    
    @Update
    suspend fun updateBooking(booking: BookingEntity)
    
    @Delete
    suspend fun deleteBooking(booking: BookingEntity)
    
    @Query("DELETE FROM bookings WHERE id = :bookingId")
    suspend fun deleteBookingById(bookingId: String)
}
