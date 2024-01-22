package es.javiKotlinDev.pokeapicompose.ui.navigation

sealed class Routes(val route: String) {

    object MenuOptions : Routes("menuOptions")
    object SearchPokemon : Routes("searchPokemon")
    object Pokedex : Routes("pokedex")
    object Types : Routes("types")
    object Berries : Routes("berries")
    object Items : Routes("items")
    object Generations : Routes("generations")
}