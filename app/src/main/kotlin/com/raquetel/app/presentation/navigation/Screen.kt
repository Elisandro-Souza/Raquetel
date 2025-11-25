package com.raquetel.app.presentation.navigation

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object CourtList : Screen("court_list")
    object CreateCourt : Screen("create_court")
    object BookingList : Screen("booking_list")
    object CreateBooking : Screen("create_booking")
    object BookingDetail : Screen("booking_detail/{bookingId}") {
        fun createRoute(bookingId: String) = "booking_detail/$bookingId"
    }
    object CustomerList : Screen("customer_list")
    object CreateCustomer : Screen("create_customer")
    object CustomerDetail : Screen("customer_detail/{customerId}") {
        fun createRoute(customerId: String) = "customer_detail/$customerId"
    }
}
