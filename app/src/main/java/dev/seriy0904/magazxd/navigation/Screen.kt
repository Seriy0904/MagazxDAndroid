package dev.seriy0904.magazxd.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import dev.seriy0904.magazxd.R

sealed class Screen(val route: String, @StringRes val resourceId: Int, val icon: ImageVector = Icons.Default.Home) {
    object Home : Screen("home", R.string.home, Icons.Default.Home)
    object Cart : Screen("cart", R.string.cart, Icons.Default.ShoppingCart)
    object Profile : Screen("profile", R.string.profile, Icons.Default.Person)

    object Settings : Screen("settings", R.string.settings)
}