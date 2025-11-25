package com.raquetel.app.presentation.screens.court

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raquetel.app.domain.entities.Court
import com.raquetel.app.domain.usecases.court.GetCourtsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CourtUiState(
    val courts: List<Court> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class CourtViewModel @Inject constructor(
    private val getCourtsUseCase: GetCourtsUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(CourtUiState())
    val uiState: StateFlow<CourtUiState> = _uiState.asStateFlow()
    
    init {
        loadCourts()
    }
    
    private fun loadCourts() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            getCourtsUseCase().collect { courts ->
                _uiState.value = CourtUiState(
                    courts = courts,
                    isLoading = false
                )
            }
        }
    }
}
