package com.raquetel.app.domain.repositories

import com.raquetel.app.core.util.Result
import com.raquetel.app.domain.entities.Court
import kotlinx.coroutines.flow.Flow

interface CourtRepository {
    
    fun getAll(): Flow<List<Court>>
    
    fun getActive(): Flow<List<Court>>
    
    suspend fun getById(id: String): Result<Court>
    
    suspend fun save(court: Court): Result<Court>
    
    suspend fun delete(id: String): Result<Unit>
}
