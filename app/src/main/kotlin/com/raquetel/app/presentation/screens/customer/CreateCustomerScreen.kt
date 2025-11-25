package com.raquetel.app.presentation.screens.customer

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.raquetel.app.domain.entities.Customer
import com.raquetel.app.domain.entities.SkillLevel
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCustomerScreen(
    onNavigateBack: () -> Unit,
    onCustomerCreated: () -> Unit,
    viewModel: CreateCustomerViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    var name by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var selectedSkillLevel by remember { mutableStateOf(SkillLevel.BEGINNER) }
    var showSkillLevelMenu by remember { mutableStateOf(false) }
    
    LaunchedEffect(uiState.customerCreated) {
        if (uiState.customerCreated) {
            onCustomerCreated()
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cadastrar Cliente") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nome Completo *") },
                modifier = Modifier.fillMaxWidth()
            )
            
            OutlinedTextField(
                value = cpf,
                onValueChange = { cpf = it },
                label = { Text("CPF *") },
                modifier = Modifier.fillMaxWidth()
            )
            
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
            
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Telefone *") },
                modifier = Modifier.fillMaxWidth()
            )
            
            ExposedDropdownMenuBox(
                expanded = showSkillLevelMenu,
                onExpandedChange = { showSkillLevelMenu = !showSkillLevelMenu }
            ) {
                OutlinedTextField(
                    value = selectedSkillLevel.displayName,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Nível de Habilidade") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = showSkillLevelMenu) }
                )
                
                ExposedDropdownMenu(
                    expanded = showSkillLevelMenu,
                    onDismissRequest = { showSkillLevelMenu = false }
                ) {
                    SkillLevel.values().forEach { level ->
                        DropdownMenuItem(
                            text = { Text(level.displayName) },
                            onClick = {
                                selectedSkillLevel = level
                                showSkillLevelMenu = false
                            }
                        )
                    }
                }
            }
            
            if (uiState.error != null) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                ) {
                    Text(
                        text = uiState.error ?: "",
                        modifier = Modifier.padding(16.dp),
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            Button(
                onClick = {
                    val customer = Customer(
                        id = "customer-${UUID.randomUUID()}",
                        name = name,
                        cpf = cpf,
                        email = email.ifBlank { null },
                        phone = phone,
                        birthDate = null,
                        address = null,
                        skillLevel = selectedSkillLevel
                    )
                    viewModel.createCustomer(customer)
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = name.isNotBlank() && cpf.isNotBlank() && phone.isNotBlank() && !uiState.isLoading
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text("Cadastrar Cliente")
                }
            }
        }
    }
}
