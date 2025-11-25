package com.raquetel.app.domain.usecases.customer

import com.raquetel.app.core.util.Result
import com.raquetel.app.domain.entities.Customer
import com.raquetel.app.domain.repositories.CustomerRepository
import javax.inject.Inject

class CreateCustomerUseCase @Inject constructor(
    private val repository: CustomerRepository
) {
    suspend operator fun invoke(customer: Customer): Result<Customer> {
        // Validar CPF único
        when (val result = repository.getByCpf(customer.cpf)) {
            is Result.Success -> return Result.Error("CPF já cadastrado")
            is Result.Error -> {} // CPF não encontrado, pode prosseguir
            is Result.Loading -> {}
        }
        
        // Validar nome
        if (customer.name.isBlank()) {
            return Result.Error("Nome não pode estar vazio")
        }
        
        // Validar telefone
        if (customer.phone.isBlank()) {
            return Result.Error("Telefone não pode estar vazio")
        }
        
        return repository.save(customer)
    }
}
