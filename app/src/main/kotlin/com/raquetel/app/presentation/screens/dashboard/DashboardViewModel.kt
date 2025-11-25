package com.raquetel.app.presentation.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raquetel.app.domain.usecases.booking.GetBookingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DashboardUiState(
    val totalBookings: Int = 0,
    val activeBookings: Int = 0,
    val totalRevenue: Double = 0.0,
    val isLoading: Boolean = false
)

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getBookingsUseCase: GetBookingsUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()
    
    init {
        loadDashboardData()
    }
    
    private fun loadDashboardData() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            getBookingsUseCase().collect { bookings ->
                val activeBookings = bookings.filter { 
                    it.status.name !in listOf("CANCELLED", "COMPLETED") 
                }
                val totalRevenue = bookings
                    .filter { it.status.name != "CANCELLED" }
                    .sumOf { it.totalAmount }
                
                _uiState.value = DashboardUiState(
                    totalBookings = bookings.size,
                    activeBookings = activeBookings.size,
                    totalRevenue = totalRevenue,
                    isLoading = false
                )
            }
        }
    }
}
