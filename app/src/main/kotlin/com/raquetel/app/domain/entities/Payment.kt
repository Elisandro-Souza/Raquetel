package com.raquetel.app.domain.entities

data class Payment(
    val id: String,
    val bookingId: String,
    val amount: Double,
    val paymentMethod: PaymentMethod,
    val paymentDate: Long = System.currentTimeMillis(),
    val status: PaymentStatus,
    val transactionId: String? = null,
    val notes: String? = null
) {
    fun isCompleted(): Boolean {
        return status == PaymentStatus.COMPLETED
    }

    fun canBeRefunded(): Boolean {
        return status == PaymentStatus.COMPLETED
    }
}

enum class PaymentMethod(val displayName: String) {
    CASH("Dinheiro"),
    CREDIT_CARD("Cartão de Crédito"),
    DEBIT_CARD("Cartão de Débito"),
    PIX("PIX"),
    TRANSFER("Transferência")
}

enum class PaymentStatus {
    PENDING,
    COMPLETED,
    REFUNDED,
    FAILED
}
