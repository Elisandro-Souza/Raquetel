package com.raquetel.app.domain.repositories

import com.raquetel.app.core.util.Result
import com.raquetel.app.domain.entities.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {
    
    fun getAll(): Flow<List<Customer>>
    
    suspend fun getById(id: String): Result<Customer>
    
    suspend fun getByCpf(cpf: String): Result<Customer>
    
    suspend fun getByPhone(phone: String): Result<Customer>
    
    suspend fun searchByName(name: String): Result<List<Customer>>
    
    suspend fun save(customer: Customer): Result<Customer>
    
    suspend fun delete(id: String): Result<Unit>
}
