package com.raquetel.app.di

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.raquetel.app.data.local.database.RaquetelDatabase
import com.raquetel.app.domain.entities.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    
    @Provides
    @Singleton
    fun provideDatabaseCallback(
        @ApplicationContext context: Context,
        database: RaquetelDatabase
    ): RoomDatabase.Callback {
        return object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    initializeSampleData(database)
                }
            }
        }
    }
    
    private suspend fun initializeSampleData(database: RaquetelDatabase) {
        val courtDao = database.courtDao()
        val customerDao = database.customerDao()
        val bookingDao = database.bookingDao()
        
        // Adicionar quadras
        val courts = listOf(
            Court(
                id = "court-1",
                name = "Quadra Central",
                type = CourtType.PROFESSIONAL,
                hourlyRate = 120.0,
                isCovered = true,
                isActive = true
            ),
            Court(
                id = "court-2",
                name = "Quadra Descoberta 1",
                type = CourtType.STANDARD,
                hourlyRate = 80.0,
                isCovered = false,
                isActive = true
            ),
            Court(
                id = "court-3",
                name = "Quadra Descoberta 2",
                type = CourtType.STANDARD,
                hourlyRate = 80.0,
                isCovered = false,
                isActive = true
            )
        )
        
        courts.forEach { court ->
            courtDao.insertCourt(
                com.raquetel.app.data.local.entities.CourtEntity(
                    id = court.id,
                    name = court.name,
                    type = court.type.name,
                    hourlyRate = court.hourlyRate,
                    isCovered = court.isCovered,
                    isActive = court.isActive
                )
            )
        }
        
        // Adicionar clientes de exemplo
        val customers = listOf(
            Customer(
                id = "customer-1",
                name = "João Silva",
                cpf = "11111111111",
                email = "joao@email.com",
                phone = "(11) 98765-4321",
                birthDate = LocalDate.of(1990, 5, 15),
                address = "Rua A, 123 - São Paulo",
                skillLevel = SkillLevel.INTERMEDIATE
            ),
            Customer(
                id = "customer-2",
                name = "Maria Santos",
                cpf = "22222222222",
                email = "maria@email.com",
                phone = "(11) 98765-1234",
                birthDate = LocalDate.of(1995, 8, 20),
                address = "Rua B, 456 - São Paulo",
                skillLevel = SkillLevel.BEGINNER
            )
        )
        
        customers.forEach { customer ->
            customerDao.insertCustomer(
                com.raquetel.app.data.local.entities.CustomerEntity(
                    id = customer.id,
                    name = customer.name,
                    cpf = customer.cpf,
                    email = customer.email,
                    phone = customer.phone,
                    birthDate = customer.birthDate,
                    address = customer.address,
                    skillLevel = customer.skillLevel.name
                )
            )
        }
        
        // Adicionar agendamentos de exemplo
        val today = LocalDate.now()
        val bookings = listOf(
            Booking(
                id = "booking-1",
                customerId = "customer-1",
                courtId = "court-1",
                bookingDate = today,
                startTime = LocalTime.of(9, 0),
                endTime = LocalTime.of(10, 30),
                durationHours = 1.5f,
                totalAmount = 180.0,
                status = BookingStatus.CONFIRMED
            ),
            Booking(
                id = "booking-2",
                customerId = "customer-2",
                courtId = "court-2",
                bookingDate = today.plusDays(1),
                startTime = LocalTime.of(14, 0),
                endTime = LocalTime.of(15, 0),
                durationHours = 1.0f,
                totalAmount = 80.0,
                status = BookingStatus.CONFIRMED
            )
        )
        
        bookings.forEach { booking ->
            bookingDao.insertBooking(
                com.raquetel.app.data.local.entities.BookingEntity(
                    id = booking.id,
                    customerId = booking.customerId,
                    courtId = booking.courtId,
                    bookingDate = booking.bookingDate,
                    startTime = booking.startTime,
                    endTime = booking.endTime,
                    durationHours = booking.durationHours,
                    totalAmount = booking.totalAmount,
                    status = booking.status.name,
                    checkInTime = booking.checkInTime,
                    cancellationReason = booking.cancellationReason
                )
            )
        }
    }
}
