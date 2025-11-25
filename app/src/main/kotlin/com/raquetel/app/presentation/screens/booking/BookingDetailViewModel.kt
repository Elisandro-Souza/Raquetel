package com.raquetel.app.presentation.screens.booking

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raquetel.app.domain.entities.Booking
import com.raquetel.app.domain.repositories.BookingRepository
import com.raquetel.app.domain.usecases.booking.CancelBookingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class BookingDetailUiState(
    val booking: Booking? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class BookingDetailViewModel @Inject constructor(
    private val bookingRepository: BookingRepository,
    private val cancelBookingUseCase: CancelBookingUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(BookingDetailUiState())
    val uiState: StateFlow<BookingDetailUiState> = _uiState.asStateFlow()
    
    fun loadBooking(bookingId: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            when (val result = bookingRepository.getById(bookingId)) {
                is com.raquetel.app.core.util.Result.Success -> {
                    _uiState.value = BookingDetailUiState(
                        booking = result.data,
                        isLoading = false
                    )
                }
                is com.raquetel.app.core.util.Result.Error -> {
                    _uiState.value = BookingDetailUiState(
                        booking = null,
                        isLoading = false,
                        error = result.message
                    )
                }
                is com.raquetel.app.core.util.Result.Loading -> {
                    _uiState.value = _uiState.value.copy(isLoading = true)
                }
            }
        }
    }
    
    fun cancelBooking(reason: String) {
        viewModelScope.launch {
            val bookingId = _uiState.value.booking?.id ?: return@launch
            cancelBookingUseCase(bookingId, reason)
        }
    }
}
