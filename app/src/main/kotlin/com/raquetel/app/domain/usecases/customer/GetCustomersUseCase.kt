package com.raquetel.app.domain.usecases.customer

import com.raquetel.app.domain.entities.Customer
import com.raquetel.app.domain.repositories.CustomerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCustomersUseCase @Inject constructor(
    private val repository: CustomerRepository
) {
    operator fun invoke(): Flow<List<Customer>> {
        return repository.getAll()
    }
}
