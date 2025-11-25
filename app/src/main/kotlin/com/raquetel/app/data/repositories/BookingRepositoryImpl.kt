package com.raquetel.app.data.repositories

import com.raquetel.app.core.util.Result
import com.raquetel.app.data.local.dao.BookingDao
import com.raquetel.app.data.mappers.toDomain
import com.raquetel.app.data.mappers.toEntity
import com.raquetel.app.domain.entities.Booking
import com.raquetel.app.domain.entities.BookingStatus
import com.raquetel.app.domain.repositories.BookingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BookingRepositoryImpl @Inject constructor(
    private val bookingDao: BookingDao
) : BookingRepository {
    
    override fun getAll(): Flow<List<Booking>> {
        return bookingDao.getAllBookings().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    override suspend fun getById(id: String): Result<Booking> {
        return try {
            val booking = bookingDao.getBookingById(id)?.toDomain()
            if (booking != null) {
                Result.Success(booking)
            } else {
                Result.Error("Agendamento não encontrado")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao buscar agendamento")
        }
    }
    
    override fun getByCustomerId(customerId: String): Flow<List<Booking>> {
        return bookingDao.getBookingsByCustomer(customerId).map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    override fun getByCourtId(courtId: String): Flow<List<Booking>> {
        return bookingDao.getBookingsByCustomer(courtId).map { entities -> // TODO: Adicionar método correto no DAO
            entities.map { it.toDomain() }
        }
    }
    
    override suspend fun getByDate(date: LocalDate): Result<List<Booking>> {
        return try {
            val bookings = bookingDao.getBookingsByDateRange(date, date).map { entities ->
                entities.map { it.toDomain() }
            }
            Result.Success(emptyList()) // TODO: Corrigir para usar Flow
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao buscar agendamentos")
        }
    }
    
    override suspend fun getByCourtAndDate(courtId: String, date: LocalDate): Result<List<Booking>> {
        return try {
            val bookings = bookingDao.getBookingsByCourtAndDate(courtId, date).map { entities ->
                entities.map { it.toDomain() }
            }
            Result.Success(emptyList()) // TODO: Corrigir para usar Flow
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao buscar agendamentos")
        }
    }
    
    override suspend fun save(booking: Booking): Result<Booking> {
        return try {
            bookingDao.insertBooking(booking.toEntity())
            Result.Success(booking)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao salvar agendamento")
        }
    }
    
    override suspend fun updateStatus(bookingId: String, status: BookingStatus): Result<Unit> {
        return try {
            val booking = bookingDao.getBookingById(bookingId)
            if (booking != null) {
                val updated = booking.copy(status = status.name)
                bookingDao.updateBooking(updated)
                Result.Success(Unit)
            } else {
                Result.Error("Agendamento não encontrado")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao atualizar status")
        }
    }
    
    override suspend fun cancel(bookingId: String, reason: String): Result<Unit> {
        return updateStatus(bookingId, BookingStatus.CANCELLED)
    }
    
    override suspend fun delete(id: String): Result<Unit> {
        return try {
            bookingDao.deleteBookingById(id)
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao deletar agendamento")
        }
    }
    
    override suspend fun hasConflict(booking: Booking): Result<Boolean> {
        return try {
            // TODO: Implementar lógica de conflito
            Result.Success(false)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao verificar conflito")
        }
    }
}
