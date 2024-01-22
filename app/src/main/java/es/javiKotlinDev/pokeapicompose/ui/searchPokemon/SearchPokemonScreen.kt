package es.javiKotlinDev.pokeapicompose.ui.searchPokemon

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import es.javiKotlinDev.pokeapicompose.R
import es.javiKotlinDev.pokeapicompose.constans.PokeApiConstants
import es.javiKotlinDev.pokeapicompose.data.domain.PokemonDomain
import es.javiKotlinDev.pokeapicompose.data.domain.SearchPokemonUseCase
import es.javiKotlinDev.pokeapicompose.data.domain.StatsDomain
import es.javiKotlinDev.pokeapicompose.data.domain.TypesDomain
import es.javiKotlinDev.pokeapicompose.data.response.AsyncResult
import es.javiKotlinDev.pokeapicompose.ui.theme.dark
import es.javiKotlinDev.pokeapicompose.ui.theme.darkGray
import es.javiKotlinDev.pokeapicompose.ui.theme.darkTransparent
import es.javiKotlinDev.pokeapicompose.ui.theme.teal
import es.javiKotlinDev.pokeapicompose.ui.theme.transparent
import es.javiKotlinDev.pokeapicompose.ui.theme.white
import es.javiKotlinDev.pokeapicompose.ui.theme.whiteTransparent
import es.javiKotlinDev.pokeapicompose.utils.capitalizeFirstLetter
import kotlinx.coroutines.flow.Flow

@Composable
fun SearchPokemonScreen(
    viewModel: SearchPokemonViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    SearchPokemonView(viewModel = viewModel, navigateBack = navigateBack)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchPokemonView(
    viewModel: SearchPokemonViewModel,
    navigateBack: () -> Unit
) {
    var idOrName by remember { mutableStateOf(PokeApiConstants.EMPTY_TEXT) }
    var id by remember { mutableIntStateOf(PokeApiConstants.ZERO) }
    var name by remember { mutableStateOf(PokeApiConstants.EMPTY_TEXT) }
    var types by remember { mutableStateOf(emptyList<TypesDomain>()) }
    var weight by remember { mutableIntStateOf(PokeApiConstants.ZERO) }
    var height by remember { mutableIntStateOf(PokeApiConstants.ZERO) }
    var baseExperience by remember { mutableIntStateOf(PokeApiConstants.ZERO) }
    var isDefault by remember { mutableStateOf(false) }
    var stats by remember { mutableStateOf(emptyList<StatsDomain>()) }
    var image by remember { mutableStateOf(PokeApiConstants.EMPTY_TEXT) }
    var imageShiny by remember { mutableStateOf(PokeApiConstants.EMPTY_TEXT) }
    val searchPokemonState by viewModel.getSearchPokemonLiveData().observeAsState()

    val painterImage = rememberImagePainter(
        data = image,
        builder = {
            crossfade(true)
            placeholder(R.drawable.pokemon)
        }
    )

    val painterShinny = rememberImagePainter(
        data = imageShiny,
        builder = {
            crossfade(true)
            placeholder(R.drawable.pokemon)
        }
    )

    when (val result = searchPokemonState) {
        is AsyncResult.Success<*> -> {
            result.data?.let {
                id = it.id
                name = it.name
                types = it.types
                weight = it.weight
                height = it.height
                baseExperience = it.baseExperience
                stats = it.stats
                isDefault = it.isDefault
                image = it.sprites.frontDefault
                imageShiny = it.sprites.frontShiny
            }
        }

        is AsyncResult.Error<*> -> {
            Toast.makeText(
                LocalContext.current,
                "Error: ${result.error.errorMessage}",
                Toast.LENGTH_SHORT
            ).show()
        }

        is AsyncResult.Loading<*> -> {
            /*no-op*/
        }

        else -> { /*no-op*/ }
    }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(dark)
        .padding(bottom = 50.dp),
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp),
                painter = painterImage,
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp),
                painter = painterShinny,
                contentDescription = null
            )
        }

        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(top = 10.dp, start = 30.dp, end = 30.dp)
                .background(white)
        ) {
            if (id != 0) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 30.dp, end = 10.dp),
                ) {

                    Text(
                        text = "ID: $id",
                        fontSize = 24.sp,
                        color = teal,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = name.uppercase(),
                        fontSize = 26.sp,
                        color = dark,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                    )
                    Spacer(modifier = Modifier.height(14.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(darkTransparent)
                            .padding(10.dp),
                    ) {
                        Text(
                            text = "Type: ${
                                types.joinToString(", ") {
                                    capitalizeFirstLetter(it.type.name)
                                }
                            }",
                            fontSize = 18.sp,
                            color = dark,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Text(
                                text = "Weight: ${weight / 10} Kg",
                                fontSize = 18.sp,
                                color = dark,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                            )
                            Text(
                                modifier = Modifier
                                    .padding(start = 40.dp),
                                text = "Height: ${weight / 10} M",
                                fontSize = 18.sp,
                                color = dark,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "Base Stats: ${stats.firstOrNull()?.baseStat}",
                            fontSize = 18.sp,
                            color = dark,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Base experience gained for\ndefeating: $baseExperience",
                            fontSize = 18.sp,
                            color = dark,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2,
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Is Default? $isDefault",
                            fontSize = 18.sp,
                            color = dark,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                        )
                    }

                }
            } else {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 150.dp),
                ) {
                    Text(
                        text = "Search\nfor a\nPokemon",
                        fontSize = 24.sp,
                        color = dark,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                    )
                }

            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 30.dp)
                .background(darkGray),
        ) {
            TextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, top = 5.dp, end = 5.dp, bottom = 5.dp),
                value = idOrName,
                onValueChange = { newText -> idOrName = newText },
                label = { Text("Search by Id or Name") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = white,
                    focusedIndicatorColor = transparent,
                    unfocusedIndicatorColor = transparent,
                ),
            )

            Button(
                modifier = Modifier
                    .padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = teal,
                ),
                onClick = {
                          viewModel.searchPokemon(idOrName)
                },
            ) {
                Text(text = "Search")
            }
        }
    }

}

@Preview
@Composable
private fun PreviewSearchScreen() {
    val useCase = SearchPokemonUseCaseMock()
    val viewModel = SearchPokemonViewModel(searchPokemonUseCase = useCase)

    SearchPokemonView(viewModel = viewModel, navigateBack = {})
}

// Implementación de prueba de SearchPokemonUseCase para la vista previa
class SearchPokemonUseCaseMock : SearchPokemonUseCase {
    override suspend fun invoke(idOrName: String): Flow<AsyncResult<PokemonDomain>> {
        TODO("Not yet implemented")
    }
}