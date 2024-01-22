package es.javiKotlinDev.pokeapicompose.ui.menuOptions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import es.javiKotlinDev.pokeapicompose.R
import es.javiKotlinDev.pokeapicompose.ui.customs.buttoms.MenuButton
import es.javiKotlinDev.pokeapicompose.ui.theme.darkTransparent

@Composable
fun MenuOptionsScreen(
    viewModel: MenuOptionsViewModel = hiltViewModel(),
    navigateToSearchPokemon: () -> Unit,
    navigateToPokedex: () -> Unit,
    navigateToTypes: () -> Unit,
    navigateToBerries: () -> Unit,
    navigateToItems: () -> Unit,
    navigateToGenerations: () -> Unit,
) {
    MenuBackground()
    MenuOptions(
        navigateToSearchPokemon = navigateToSearchPokemon,
        navigateToPokedex = navigateToPokedex,
        navigateToTypes = navigateToTypes,
        navigateToBerries = navigateToBerries,
        navigateToItems = navigateToItems,
        navigateToGenerations = navigateToGenerations,
    )
}

@Composable
private fun MenuBackground() {
    Image(
        painter = painterResource(id = R.drawable.bg_login),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun MenuOptions(
    modifier: Modifier = Modifier,
    navigateToSearchPokemon: () -> Unit,
    navigateToPokedex: () -> Unit,
    navigateToTypes: () -> Unit,
    navigateToBerries: () -> Unit,
    navigateToItems: () -> Unit,
    navigateToGenerations: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 130.dp,
                bottom = 120.dp,
                start = 30.dp,
                end = 30.dp
            )
            .background(darkTransparent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.padding(top = 30.dp))

        Row(
            modifier = Modifier
                .background(Transparent)
        ) {
            MenuButton(
                modifier = modifier
                    .padding(8.dp)
                    .weight(1f),
                text = "Pokemon",
                imageResId = R.drawable.pokemon,
                onClick = { navigateToSearchPokemon() },
            )

            MenuButton(
                modifier = modifier
                    .padding(8.dp)
                    .weight(1f),
                text = "Pokedex",
                imageResId = R.drawable.pokedex,
                onClick = { navigateToPokedex() },
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            MenuButton(
                modifier = modifier
                    .padding(8.dp)
                    .weight(1f),
                text = "Types",
                imageResId = R.drawable.electric_logo,
                onClick = { navigateToTypes()},
            )

            MenuButton(
                modifier = modifier
                    .padding(8.dp)
                    .weight(1f),
                text = "Berries",
                imageResId = R.drawable.berries,
                onClick = { navigateToBerries() },
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            MenuButton(
                modifier = modifier
                    .padding(8.dp)
                    .weight(1f),
                text = "Items",
                imageResId = R.drawable.items,
                onClick = { navigateToItems() },
            )

            MenuButton(
                modifier = modifier
                    .padding(8.dp)
                    .weight(1f),
                text = "Generations",
                imageResId = R.drawable.generations,
                onClick = { navigateToGenerations() },
            )
        }
    }
}

@Preview
@Composable
private fun PreviewMenuOptions() {
    MenuBackground()
    MenuOptions(
        navigateToSearchPokemon = { },
        navigateToPokedex = { },
        navigateToTypes = { },
        navigateToBerries = { },
        navigateToItems = { },
        navigateToGenerations = { },
    )
}