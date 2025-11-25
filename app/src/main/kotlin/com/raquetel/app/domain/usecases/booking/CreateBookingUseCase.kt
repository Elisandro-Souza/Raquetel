package com.raquetel.app.domain.usecases.booking

import com.raquetel.app.core.util.Result
import com.raquetel.app.domain.entities.Booking
import com.raquetel.app.domain.entities.BookingStatus
import com.raquetel.app.domain.repositories.BookingRepository
import kotlinx.coroutines.flow.first
import java.time.LocalDate
import javax.inject.Inject

class CreateBookingUseCase @Inject constructor(
    private val repository: BookingRepository
) {
    suspend operator fun invoke(booking: Booking): Result<Booking> {
        // Validar se a data é futura
        if (booking.bookingDate.isBefore(LocalDate.now())) {
            return Result.Error("Não é possível agendar para datas passadas")
        }
        
        // Verificar conflitos usando o método hasConflict do repositório
        return when (val conflictResult = repository.hasConflict(booking)) {
            is Result.Success -> {
                if (conflictResult.data) {
                    Result.Error("Já existe um agendamento para esta quadra neste horário")
                } else {
                    repository.save(booking)
                }
            }
            is Result.Error -> Result.Error(conflictResult.message)
            is Result.Loading -> Result.Loading
        }
    }
}
