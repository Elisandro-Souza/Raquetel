package com.raquetel.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.raquetel.app.presentation.screens.booking.BookingDetailScreen
import com.raquetel.app.presentation.screens.booking.BookingListScreen
import com.raquetel.app.presentation.screens.booking.CreateBookingScreen
import com.raquetel.app.presentation.screens.court.CourtListScreen
import com.raquetel.app.presentation.screens.court.CreateCourtScreen
import com.raquetel.app.presentation.screens.customer.CreateCustomerScreen
import com.raquetel.app.presentation.screens.customer.CustomerListScreen
import com.raquetel.app.presentation.screens.dashboard.DashboardScreen

@Composable
fun RaquetelNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Dashboard.route
    ) {
        composable(Screen.Dashboard.route) {
            DashboardScreen(
                onNavigateToCourts = { navController.navigate(Screen.CourtList.route) },
                onNavigateToBookings = { navController.navigate(Screen.BookingList.route) },
                onNavigateToCustomers = { navController.navigate(Screen.CustomerList.route) },
                onNavigateToCreateBooking = { navController.navigate(Screen.CreateBooking.route) }
            )
        }
        
        composable(Screen.CourtList.route) {
            CourtListScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToCreateCourt = { navController.navigate(Screen.CreateCourt.route) }
            )
        }
        
        composable(Screen.CreateCourt.route) {
            CreateCourtScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.BookingList.route) {
            BookingListScreen(
                onNavigateBack = { navController.popBackStack() },
                onBookingClick = { bookingId ->
                    navController.navigate(Screen.BookingDetail.createRoute(bookingId))
                },
                onCreateBookingClick = {
                    navController.navigate(Screen.CreateBooking.route)
                }
            )
        }
        
        composable(Screen.CreateBooking.route) {
            CreateBookingScreen(
                onNavigateBack = { navController.popBackStack() },
                onBookingCreated = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(
            route = Screen.BookingDetail.route,
            arguments = listOf(navArgument("bookingId") { type = NavType.StringType })
        ) { backStackEntry ->
            val bookingId = backStackEntry.arguments?.getString("bookingId") ?: return@composable
            BookingDetailScreen(
                bookingId = bookingId,
                onNavigateBack = { navController.popBackStack() }
            )
        }
        
        composable(Screen.CustomerList.route) {
            CustomerListScreen(
                onNavigateBack = { navController.popBackStack() },
                onCreateCustomerClick = {
                    navController.navigate(Screen.CreateCustomer.route)
                }
            )
        }
        
        composable(Screen.CreateCustomer.route) {
            CreateCustomerScreen(
                onNavigateBack = { navController.popBackStack() },
                onCustomerCreated = {
                    navController.popBackStack()
                }
            )
        }
    }
}
