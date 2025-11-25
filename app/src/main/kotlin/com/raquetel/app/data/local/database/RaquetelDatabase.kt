package com.raquetel.app.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.raquetel.app.data.local.dao.BookingDao
import com.raquetel.app.data.local.dao.CourtDao
import com.raquetel.app.data.local.dao.CustomerDao
import com.raquetel.app.data.local.entities.BookingEntity
import com.raquetel.app.data.local.entities.CourtEntity
import com.raquetel.app.data.local.entities.CustomerEntity

@Database(
    entities = [
        CustomerEntity::class,
        CourtEntity::class,
        BookingEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RaquetelDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao
    abstract fun courtDao(): CourtDao
    abstract fun bookingDao(): BookingDao
    
    companion object {
        const val DATABASE_NAME = "raquetel_database"
    }
}
