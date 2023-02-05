package dev.seriy0904.magazxd.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dev.seriy0904.magazxd.navigation.NavigationActions
import dev.seriy0904.magazxd.navigation.Screen
import dev.seriy0904.magazxd.navigation.SetupNavGraph

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MagazxDApp() {
    val navController = rememberAnimatedNavController()
    val navigationActions = remember(navController) {
        NavigationActions(navController)
    }
//    val bottomBarState = rememberBo
    Scaffold(bottomBar = {
        BottomBar(navigationActions = navigationActions)
    }) {
        Box(modifier = Modifier.padding(it)) {
            SetupNavGraph(navController,navigationActions)
        }
    }
}

@Composable
fun BottomBar(navigationActions: NavigationActions) {
    val navBackEntry by navigationActions.navController.currentBackStackEntryAsState()
    val destination = navBackEntry?.destination
    val bottomItems = listOf(Screen.Home, Screen.Cart, Screen.Profile)
    if(destination?.route in bottomItems.map { it.route }){
        BottomNavigation (){
            for (i in bottomItems) {
                BottomNavigationItem(
                    label = { Text(text = stringResource(id = i.resourceId)) },
                    selected = (destination?.route ?: "home") == i.route,
                    icon = { Icon(imageVector = i.icon, contentDescription = "home") },
                    onClick = {
                        when(i.route){
                            Screen.Home.route -> navigationActions.navigateToHome()
                            Screen.Cart.route -> navigationActions.navigateToCart()
                            Screen.Profile.route -> navigationActions.navigateToProfile()
                        }
                    }
                )
            }
        }
    }
}