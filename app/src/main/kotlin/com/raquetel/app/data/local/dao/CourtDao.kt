package com.raquetel.app.data.local.dao

import androidx.room.*
import com.raquetel.app.data.local.entities.CourtEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourtDao {
    
    @Query("SELECT * FROM courts ORDER BY name ASC")
    fun getAllCourts(): Flow<List<CourtEntity>>
    
    @Query("SELECT * FROM courts WHERE isActive = 1 ORDER BY name ASC")
    fun getActiveCourts(): Flow<List<CourtEntity>>
    
    @Query("SELECT * FROM courts WHERE id = :courtId")
    suspend fun getCourtById(courtId: String): CourtEntity?
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourt(court: CourtEntity)
    
    @Update
    suspend fun updateCourt(court: CourtEntity)
    
    @Delete
    suspend fun deleteCourt(court: CourtEntity)
}
