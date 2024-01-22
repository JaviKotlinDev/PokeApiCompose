package es.javiKotlinDev.pokeapicompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.javiKotlinDev.pokeapicompose.ui.menuOptions.MenuOptionsScreen
import es.javiKotlinDev.pokeapicompose.ui.searchPokemon.SearchPokemonScreen

@Composable
fun NavigationHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MenuOptions.route,
    ) {

        composable(Routes.MenuOptions.route) {
            MenuOptionsScreen(
                navigateToSearchPokemon = { navController.navigate(Routes.SearchPokemon.route)},
                navigateToPokedex = { navController.navigate(Routes.Pokedex.route)},
                navigateToTypes = { navController.navigate(Routes.Types.route)},
                navigateToBerries = { navController.navigate(Routes.Berries.route)},
                navigateToItems = { navController.navigate(Routes.Items.route)},
                navigateToGenerations = { navController.navigate(Routes.Generations.route)},
            )
        }

        composable(Routes.SearchPokemon.route) {
            SearchPokemonScreen(
                navigateBack = { navController.popBackStack() }
            )
        }

        composable(Routes.Pokedex.route) {
            //PokedexScreen()
        }

        composable(Routes.Types.route) {
            //TypesScreen()
        }

        composable(Routes.Berries.route) {
            //BerriesScreen()
        }

        composable(Routes.Items.route) {
            //ItemsScreen()
        }

        composable(Routes.Generations.route) {
            //GenerationsScreen()
        }

    }
}