package com.raquetel.app.di

import com.raquetel.app.data.repositories.BookingRepositoryImpl
import com.raquetel.app.data.repositories.CourtRepositoryImpl
import com.raquetel.app.data.repositories.CustomerRepositoryImpl
import com.raquetel.app.domain.repositories.BookingRepository
import com.raquetel.app.domain.repositories.CourtRepository
import com.raquetel.app.domain.repositories.CustomerRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    
    @Binds
    @Singleton
    abstract fun bindCustomerRepository(
        impl: CustomerRepositoryImpl
    ): CustomerRepository
    
    @Binds
    @Singleton
    abstract fun bindCourtRepository(
        impl: CourtRepositoryImpl
    ): CourtRepository
    
    @Binds
    @Singleton
    abstract fun bindBookingRepository(
        impl: BookingRepositoryImpl
    ): BookingRepository
}
