package com.raquetel.app.di

import android.content.Context
import androidx.room.Room
import com.raquetel.app.data.local.dao.BookingDao
import com.raquetel.app.data.local.dao.CourtDao
import com.raquetel.app.data.local.dao.CustomerDao
import com.raquetel.app.data.local.database.RaquetelDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideRaquetelDatabase(
        @ApplicationContext context: Context
    ): RaquetelDatabase {
        return Room.databaseBuilder(
            context,
            RaquetelDatabase::class.java,
            RaquetelDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
    
    @Provides
    @Singleton
    fun provideCustomerDao(database: RaquetelDatabase): CustomerDao {
        return database.customerDao()
    }
    
    @Provides
    @Singleton
    fun provideCourtDao(database: RaquetelDatabase): CourtDao {
        return database.courtDao()
    }
    
    @Provides
    @Singleton
    fun provideBookingDao(database: RaquetelDatabase): BookingDao {
        return database.bookingDao()
    }
}
