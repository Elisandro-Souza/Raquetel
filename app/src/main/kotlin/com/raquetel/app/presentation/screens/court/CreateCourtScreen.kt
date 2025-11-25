package com.raquetel.app.presentation.screens.court

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.raquetel.app.domain.entities.Court
import com.raquetel.app.domain.entities.CourtType
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateCourtScreen(
    onNavigateBack: () -> Unit,
    viewModel: CreateCourtViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var courtType by remember { mutableStateOf(CourtType.STANDARD) }
    var hourlyRate by remember { mutableStateOf("") }
    var isCovered by remember { mutableStateOf(false) }
    var isActive by remember { mutableStateOf(true) }
    var showTypeMenu by remember { mutableStateOf(false) }
    
    val uiState by viewModel.uiState.collectAsState()
    
    // Efeito para mostrar mensagens e navegar de volta
    LaunchedEffect(uiState.success) {
        if (uiState.success) {
            viewModel.resetSuccess()
            onNavigateBack()
        }
    }
    
    // Mostrar erro em Snackbar
    uiState.error?.let { error ->
        LaunchedEffect(error) {
            // Snackbar será mostrado automaticamente
        }
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nova Quadra") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    val rate = hourlyRate.toDoubleOrNull() ?: 0.0
                    val court = Court(
                        id = "court-${UUID.randomUUID()}",
                        name = name,
                        type = courtType,
                        hourlyRate = rate,
                        isCovered = isCovered,
                        isActive = isActive
                    )
                    viewModel.createCourt(court)
                },
                icon = { Icon(Icons.Default.Check, contentDescription = null) },
                text = { Text("Salvar") },
                expanded = true
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Mensagem de erro
            uiState.error?.let { error ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = error,
                            color = MaterialTheme.colorScheme.onErrorContainer,
                            modifier = Modifier.weight(1f)
                        )
                        TextButton(onClick = { viewModel.clearError() }) {
                            Text("OK")
                        }
                    }
                }
            }
            
            // Nome da quadra
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nome da Quadra *") },
                placeholder = { Text("Ex: Quadra 1") },
                modifier = Modifier.fillMaxWidth(),
                enabled = !uiState.isLoading,
                singleLine = true
            )
            
            // Tipo da quadra
            ExposedDropdownMenuBox(
                expanded = showTypeMenu,
                onExpandedChange = { showTypeMenu = !showTypeMenu }
            ) {
                OutlinedTextField(
                    value = courtType.displayName,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Tipo *") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = showTypeMenu) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    enabled = !uiState.isLoading
                )
                
                ExposedDropdownMenu(
                    expanded = showTypeMenu,
                    onDismissRequest = { showTypeMenu = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(CourtType.STANDARD.displayName) },
                        onClick = {
                            courtType = CourtType.STANDARD
                            showTypeMenu = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(CourtType.PROFESSIONAL.displayName) },
                        onClick = {
                            courtType = CourtType.PROFESSIONAL
                            showTypeMenu = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(CourtType.TRAINING.displayName) },
                        onClick = {
                            courtType = CourtType.TRAINING
                            showTypeMenu = false
                        }
                    )
                }
            }
            
            // Quadra coberta
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = if (isCovered) 
                        MaterialTheme.colorScheme.secondaryContainer 
                    else 
                        MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Quadra Coberta",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = if (isCovered) "Com cobertura" else "Sem cobertura (ao ar livre)",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Switch(
                        checked = isCovered,
                        onCheckedChange = { isCovered = it },
                        enabled = !uiState.isLoading
                    )
                }
            }
            
            // Preço por hora
            OutlinedTextField(
                value = hourlyRate,
                onValueChange = { value ->
                    // Permitir apenas números e ponto decimal
                    if (value.isEmpty() || value.matches(Regex("^\\d*\\.?\\d*$"))) {
                        hourlyRate = value
                    }
                },
                label = { Text("Preço por Hora (R$) *") },
                placeholder = { Text("150.00") },
                leadingIcon = { Text("R$", style = MaterialTheme.typography.bodyLarge) },
                modifier = Modifier.fillMaxWidth(),
                enabled = !uiState.isLoading,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                singleLine = true
            )
            
            // Status ativo
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = if (isActive) 
                        MaterialTheme.colorScheme.primaryContainer 
                    else 
                        MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "Status da Quadra",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = if (isActive) "Disponível para agendamentos" else "Inativa",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Switch(
                        checked = isActive,
                        onCheckedChange = { isActive = it },
                        enabled = !uiState.isLoading
                    )
                }
            }
            
            // Informações de ajuda
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "💡 Dicas",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Text(
                        text = "• Use nomes descritivos (Ex: Quadra 1, Quadra Principal)\n" +
                               "• Padrão: quadras regulares\n" +
                               "• Profissional: quadras para competições\n" +
                               "• Treino: quadras para prática\n" +
                               "• O preço pode ser editado depois\n" +
                               "• Quadras inativas não aparecem para agendamento",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
            
            // Loading indicator
            if (uiState.isLoading) {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth()
                )
            }
            
            // Espaçamento para o FAB
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}
