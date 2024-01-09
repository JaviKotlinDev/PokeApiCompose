package es.javiKotlinDev.pokeapicompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.javiKotlinDev.pokeapicompose.ui.menuOptions.MenuOptionsScreen

@Composable
fun NavigationHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MenuOptions.route,
    ) {

        composable(Routes.MenuOptions.route) {
            MenuOptionsScreen(
                navigateToSearchPokemon = {  },
            )
        }

    }
}