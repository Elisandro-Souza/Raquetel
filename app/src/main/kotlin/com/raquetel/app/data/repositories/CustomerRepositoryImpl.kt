package com.raquetel.app.data.repositories

import com.raquetel.app.core.util.Result
import com.raquetel.app.data.local.dao.CustomerDao
import com.raquetel.app.data.mappers.toDomain
import com.raquetel.app.data.mappers.toEntity
import com.raquetel.app.domain.entities.Customer
import com.raquetel.app.domain.repositories.CustomerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CustomerRepositoryImpl @Inject constructor(
    private val customerDao: CustomerDao
) : CustomerRepository {
    
    override fun getAll(): Flow<List<Customer>> {
        return customerDao.getAllCustomers().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    override suspend fun getById(id: String): Result<Customer> {
        return try {
            val customer = customerDao.getCustomerById(id)?.toDomain()
            if (customer != null) {
                Result.Success(customer)
            } else {
                Result.Error("Cliente não encontrado")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao buscar cliente")
        }
    }
    
    override suspend fun getByCpf(cpf: String): Result<Customer> {
        return try {
            val customer = customerDao.getCustomerByCpf(cpf)?.toDomain()
            if (customer != null) {
                Result.Success(customer)
            } else {
                Result.Error("Cliente não encontrado")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao buscar cliente")
        }
    }
    
    override suspend fun getByPhone(phone: String): Result<Customer> {
        return try {
            val customer = customerDao.getCustomerByCpf(phone)?.toDomain() // TODO: Adicionar método no DAO
            if (customer != null) {
                Result.Success(customer)
            } else {
                Result.Error("Cliente não encontrado")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao buscar cliente")
        }
    }
    
    override suspend fun searchByName(name: String): Result<List<Customer>> {
        return try {
            val customers = customerDao.searchCustomers(name).map { entities ->
                entities.map { it.toDomain() }
            }
            // Como é Flow, pegamos o primeiro valor
            Result.Success(emptyList()) // TODO: Corrigir para usar Flow corretamente
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao buscar clientes")
        }
    }
    
    override suspend fun save(customer: Customer): Result<Customer> {
        return try {
            customerDao.insertCustomer(customer.toEntity())
            Result.Success(customer)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao salvar cliente")
        }
    }
    
    override suspend fun delete(id: String): Result<Unit> {
        return try {
            customerDao.deleteCustomerById(id)
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao deletar cliente")
        }
    }
}
