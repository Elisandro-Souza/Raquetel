package com.raquetel.app.domain.usecases.booking

import com.raquetel.app.core.util.Result
import com.raquetel.app.domain.entities.BookingStatus
import com.raquetel.app.domain.repositories.BookingRepository
import javax.inject.Inject

class CancelBookingUseCase @Inject constructor(
    private val repository: BookingRepository
) {
    suspend operator fun invoke(bookingId: String, reason: String): Result<Unit> {
        return when (val result = repository.getById(bookingId)) {
            is Result.Success -> {
                val booking = result.data
                
                if (booking.status == BookingStatus.CANCELLED) {
                    return Result.Error("Agendamento já está cancelado")
                }
                
                if (booking.status == BookingStatus.COMPLETED) {
                    return Result.Error("Não é possível cancelar um agendamento já concluído")
                }
                
                repository.cancel(bookingId, reason)
            }
            is Result.Error -> Result.Error("Agendamento não encontrado")
            is Result.Loading -> Result.Loading
        }
    }
}
