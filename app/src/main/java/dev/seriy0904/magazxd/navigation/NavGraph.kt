package dev.seriy0904.magazxd.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import dev.seriy0904.magazxd.view.home.Home

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    navigationActions: NavigationActions,
    startDestination: String = Screen.Home.route
) {
    AnimatedNavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.Home.route) {
            Text(text = "Home")
            Home()
        }
        composable(Screen.Cart.route) {
            Text(text = "Cart")
        }
        composable(Screen.Profile.route) {
            Text(text = "profile")
        }
        composable(Screen.Settings.route) {
            Text(text = "Settings",
                Modifier
                    .background(Color.Cyan)
                    .fillMaxSize())
        }
    }
}

class NavigationActions(val navController: NavHostController) {
    val navigateToHome = {
        navController.navigate(Screen.Home.route) {
            launchSingleTop = true
            popUpTo(route = Screen.Home.route)
            { inclusive = true }
        }
    }

    val navigateToCart = {
        navController.navigate(Screen.Cart.route) {
            launchSingleTop = true
            popUpTo(route = Screen.Home.route)
            { inclusive = true }
        }
    }

    val navigateToProfile = {
        navController.navigate(Screen.Profile.route) {
            launchSingleTop = true
            popUpTo(route = Screen.Home.route)
            { inclusive = true }
        }
    }

    val navigateToSettings = {
        navController.navigate(Screen.Settings.route)
    }
}