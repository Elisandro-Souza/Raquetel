package com.raquetel.app.domain.usecases.court

import com.raquetel.app.domain.entities.Court
import com.raquetel.app.domain.repositories.CourtRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCourtsUseCase @Inject constructor(
    private val repository: CourtRepository
) {
    operator fun invoke(): Flow<List<Court>> {
        return repository.getAll()
    }
    
    fun getActive(): Flow<List<Court>> {
        return repository.getActive()
    }
}
