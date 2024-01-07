package es.javiKotlinDev.pokeapicompose.ui.menuOptions

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import es.javiKotlinDev.pokeapicompose.ui.customs.buttoms.AcceptButton

@Composable
fun MenuOptionsScreen(
    viewModel: MenuOptionsViewModel = hiltViewModel(),
    navigateToSearchPokemon: () -> Unit,
) {
    AcceptButton(onClick = {  })
}