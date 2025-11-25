package com.raquetel.app.presentation.screens.booking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raquetel.app.core.util.Result
import com.raquetel.app.domain.entities.Booking
import com.raquetel.app.domain.entities.BookingStatus
import com.raquetel.app.domain.entities.Court
import com.raquetel.app.domain.entities.Customer
import com.raquetel.app.domain.usecases.booking.CreateBookingUseCase
import com.raquetel.app.domain.usecases.court.GetCourtsUseCase
import com.raquetel.app.domain.usecases.customer.GetCustomersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.util.*
import javax.inject.Inject

data class CreateBookingUiState(
    val customers: List<Customer> = emptyList(),
    val courts: List<Court> = emptyList(),
    val selectedCustomer: Customer? = null,
    val selectedCourt: Court? = null,
    val isLoading: Boolean = false,
    val bookingCreated: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class CreateBookingViewModel @Inject constructor(
    private val getCustomersUseCase: GetCustomersUseCase,
    private val getCourtsUseCase: GetCourtsUseCase,
    private val createBookingUseCase: CreateBookingUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(CreateBookingUiState())
    val uiState: StateFlow<CreateBookingUiState> = _uiState.asStateFlow()
    
    fun loadData() {
        viewModelScope.launch {
            val customers = getCustomersUseCase().first()
            val courts = getCourtsUseCase.getActive().first()
            
            _uiState.value = _uiState.value.copy(
                customers = customers,
                courts = courts
            )
        }
    }
    
    fun selectCustomer(customer: Customer) {
        _uiState.value = _uiState.value.copy(selectedCustomer = customer)
    }
    
    fun selectCourt(court: Court) {
        _uiState.value = _uiState.value.copy(selectedCourt = court)
    }
    
    fun createBooking(date: LocalDate, time: LocalTime, duration: Double) {
        viewModelScope.launch {
            val customer = _uiState.value.selectedCustomer ?: return@launch
            val court = _uiState.value.selectedCourt ?: return@launch
            
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            val endTime = time.plusMinutes((duration * 60).toLong())
            val totalAmount = court.hourlyRate * duration
            
            val booking = Booking(
                id = "booking-${UUID.randomUUID()}",
                customerId = customer.id,
                courtId = court.id,
                bookingDate = date,
                startTime = time,
                endTime = endTime,
                durationHours = duration.toFloat(),
                totalAmount = totalAmount,
                status = BookingStatus.CONFIRMED
            )
            
            when (val result = createBookingUseCase(booking)) {
                is Result.Success -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        bookingCreated = true
                    )
                }
                is Result.Error -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
                is Result.Loading -> {
                    _uiState.value = _uiState.value.copy(isLoading = true)
                }
            }
        }
    }
}
