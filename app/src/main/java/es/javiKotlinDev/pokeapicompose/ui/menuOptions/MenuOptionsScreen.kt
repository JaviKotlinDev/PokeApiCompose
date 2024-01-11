package es.javiKotlinDev.pokeapicompose.ui.menuOptions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import es.javiKotlinDev.pokeapicompose.R
import es.javiKotlinDev.pokeapicompose.ui.theme.teal
import es.javiKotlinDev.pokeapicompose.ui.theme.white

@Composable
fun MenuOptionsScreen(
    viewModel: MenuOptionsViewModel = hiltViewModel(),
    navigateToSearchPokemon: () -> Unit,
) {
    MenuBackground()
}

@Preview
@Composable
private fun MenuBackground() {
    Image(
        painter = painterResource(id = R.drawable.bg_login),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    MenuOptions()
}

@Composable
private fun MenuOptions(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
            .background(white),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .padding(20.dp)
                .background(teal)
        ) {
            // Primer botón en la primera fila
            Button(
                onClick = { /* Acción del botón 1 */ },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f) // Ocupa el 50% del ancho disponible
            ) {
                Text("Botón 1")
            }

            // Segundo botón en la primera fila
            Button(
                onClick = { /* Acción del botón 2 */ },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f) // Ocupa el 50% del ancho disponible
            ) {
                Text("Botón 2")
            }
        }

        Row(
            modifier = modifier
                .padding(20.dp)
                .background(teal)
        ) {
            // Primer botón en la segunda fila
            Button(
                onClick = { /* Acción del botón 3 */ },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f) // Ocupa el 50% del ancho disponible
            ) {
                Text("Botón 3")
            }

            // Segundo botón en la segunda fila
            Button(
                onClick = { /* Acción del botón 4 */ },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f) // Ocupa el 50% del ancho disponible
            ) {
                Text("Botón 4")
            }
        }
    }
}