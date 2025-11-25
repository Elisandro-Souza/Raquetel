# Raquetel - Sistema de Agendamento de Quadras de Padel

## Sobre o Projeto

O **Raquetel** é um aplicativo Android moderno para gestão de quadras de padel, permitindo cadastro de clientes, de quadras e agendamento de horários de forma intuitiva e eficiente.

## Funcionalidades

### Dashboard
- Visão geral com estatísticas (total de agendamentos, agendamentos ativos, receita)
- Navegação rápida para todas as funcionalidades
- Interface moderna

### Quadras
- Criação de novas quadras
- Listagem de todas as quadras cadastradas
- Visualização de detalhes (tipo, cobertura, valor por hora)
- Status de disponibilidade (ativa/inativa)

### Agendamentos
- Criação de novos agendamentos
- Listagem de todos os agendamentos
- Detalhes do agendamento com possibilidade de cancelamento
- Validação de conflitos de horário
- Status visual (Confirmado, Pendente, Cancelado, etc.)

### Clientes
- Cadastro de novos clientes
- Listagem de clientes cadastrados
- Informações de contato e nível de habilidade
- Validação de CPF único

## Arquitetura

O projeto segue os princípios de **Clean Architecture** combinada com **MVVM (Model-View-ViewModel)**

## Tecnologias Utilizadas

### Core
- **Kotlin** - Linguagem de programação
- **Jetpack Compose** - UI moderna e declarativa
- **Material Design 3** - Design system

### Arquitetura
- **MVVM Pattern** - Model-View-ViewModel
- **Clean Architecture** - Separação de responsabilidades
- **StateFlow** - Gerenciamento de estado reativo

### Persistência
- **Room Database** - Banco de dados local
- **Type Converters** - Conversão de tipos personalizados (LocalDate, LocalTime)

### Injeção de Dependências
- **Hilt (Dagger)** - Dependency Injection

### Navegação
- **Jetpack Navigation Compose** - Navegação entre telas

### Outras
- **Coroutines** - Programação assíncrona
- **Flow** - Streams reativos

## Como Executar

### Pré-requisitos
- Android Studio
- JDK 17
- Android SDK 34

### Passos

1. **Clone o repositório**
```bash
git clone <url-do-repositorio>
cd Raquetel
```

2. **Compilando via Terminal**

```bash
# Build debug
./gradlew assembleDebug

# Build release
./gradlew assembleRelease
```

3. **Abra o Emulador do Android Studio**
   - Instale a APK no emulador (arraste e solte)

## Banco de Dados

O aplicativo usa **Room Database** com as seguintes tabelas:

### Customers
- id, name, cpf, email, phone
- birthDate, address, skillLevel
- createdAt, updatedAt

### Courts
- id, name, type, hourlyRate
- isCovered, isActive, createdAt

### Bookings
- id, customerId, courtId
- bookingDate, startTime, endTime
- durationHours, totalAmount, status
- checkInTime, cancellationReason
- createdAt, updatedAt

## Licença

Este projeto foi desenvolvido para fins educacionais usando Kotlin/Android.

## Autor

Elisandro Souza

---

**Raquetel - Transformando a gestão de quadras de padel em uma experiência moderna e intuitiva!**
