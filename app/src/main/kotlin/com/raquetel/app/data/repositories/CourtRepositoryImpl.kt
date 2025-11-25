package com.raquetel.app.data.repositories

import com.raquetel.app.core.util.Result
import com.raquetel.app.data.local.dao.CourtDao
import com.raquetel.app.data.mappers.toDomain
import com.raquetel.app.data.mappers.toEntity
import com.raquetel.app.domain.entities.Court
import com.raquetel.app.domain.repositories.CourtRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CourtRepositoryImpl @Inject constructor(
    private val courtDao: CourtDao
) : CourtRepository {
    
    override fun getAll(): Flow<List<Court>> {
        return courtDao.getAllCourts().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    override fun getActive(): Flow<List<Court>> {
        return courtDao.getActiveCourts().map { entities ->
            entities.map { it.toDomain() }
        }
    }
    
    override suspend fun getById(id: String): Result<Court> {
        return try {
            val court = courtDao.getCourtById(id)?.toDomain()
            if (court != null) {
                Result.Success(court)
            } else {
                Result.Error("Quadra não encontrada")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao buscar quadra")
        }
    }
    
    override suspend fun save(court: Court): Result<Court> {
        return try {
            courtDao.insertCourt(court.toEntity())
            Result.Success(court)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao salvar quadra")
        }
    }
    
    override suspend fun delete(id: String): Result<Unit> {
        return try {
            val court = courtDao.getCourtById(id)
            if (court != null) {
                courtDao.deleteCourt(court)
                Result.Success(Unit)
            } else {
                Result.Error("Quadra não encontrada")
            }
        } catch (e: Exception) {
            Result.Error(e.message ?: "Erro ao deletar quadra")
        }
    }
}
