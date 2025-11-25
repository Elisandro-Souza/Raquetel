package com.raquetel.app.presentation.screens.court

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raquetel.app.core.util.Result
import com.raquetel.app.domain.entities.Court
import com.raquetel.app.domain.entities.CourtType
import com.raquetel.app.domain.usecases.court.SaveCourtUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CreateCourtUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Boolean = false
)

@HiltViewModel
class CreateCourtViewModel @Inject constructor(
    private val saveCourtUseCase: SaveCourtUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(CreateCourtUiState())
    val uiState: StateFlow<CreateCourtUiState> = _uiState.asStateFlow()
    
    fun createCourt(court: Court) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            when (val result = saveCourtUseCase(court)) {
                is Result.Success -> {
                    _uiState.value = CreateCourtUiState(
                        isLoading = false,
                        success = true
                    )
                }
                is Result.Error -> {
                    _uiState.value = CreateCourtUiState(
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
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
    
    fun resetSuccess() {
        _uiState.value = _uiState.value.copy(success = false)
    }
}
