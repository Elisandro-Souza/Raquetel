package com.raquetel.app.domain.usecases.booking

import com.raquetel.app.domain.entities.Booking
import com.raquetel.app.domain.repositories.BookingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBookingsUseCase @Inject constructor(
    private val repository: BookingRepository
) {
    operator fun invoke(): Flow<List<Booking>> {
        return repository.getAll()
    }
}
