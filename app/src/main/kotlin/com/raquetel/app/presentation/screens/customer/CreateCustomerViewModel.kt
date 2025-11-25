package com.raquetel.app.presentation.screens.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raquetel.app.core.util.Result
import com.raquetel.app.domain.entities.Customer
import com.raquetel.app.domain.usecases.customer.CreateCustomerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CreateCustomerUiState(
    val isLoading: Boolean = false,
    val customerCreated: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class CreateCustomerViewModel @Inject constructor(
    private val createCustomerUseCase: CreateCustomerUseCase
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(CreateCustomerUiState())
    val uiState: StateFlow<CreateCustomerUiState> = _uiState.asStateFlow()
    
    fun createCustomer(customer: Customer) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            
            when (val result = createCustomerUseCase(customer)) {
                is Result.Success -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        customerCreated = true
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
