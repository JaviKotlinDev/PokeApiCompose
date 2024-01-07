package es.javiKotlinDev.pokeapicompose.ui.navigation

sealed class Routes(val route: String) {

    object MenuOptions : Routes("menuOptions")

}