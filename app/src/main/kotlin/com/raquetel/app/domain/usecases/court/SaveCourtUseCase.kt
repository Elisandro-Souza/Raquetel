package com.raquetel.app.domain.usecases.court

import com.raquetel.app.core.util.Result
import com.raquetel.app.domain.entities.Court
import com.raquetel.app.domain.repositories.CourtRepository
import javax.inject.Inject

class SaveCourtUseCase @Inject constructor(
    private val repository: CourtRepository
) {
    suspend operator fun invoke(court: Court): Result<Court> {
        // Validar nome
        if (court.name.isBlank()) {
            return Result.Error("Nome da quadra não pode estar vazio")
        }
        
        // Validar preço
        if (court.hourlyRate <= 0) {
            return Result.Error("Preço por hora deve ser maior que zero")
        }
        
        return repository.save(court)
    }
}
