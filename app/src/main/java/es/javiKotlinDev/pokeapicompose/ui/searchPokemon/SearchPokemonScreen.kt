package es.javiKotlinDev.pokeapicompose.ui.searchPokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import es.javiKotlinDev.pokeapicompose.R
import es.javiKotlinDev.pokeapicompose.constans.EMPTY_TEXT
import es.javiKotlinDev.pokeapicompose.ui.theme.dark
import es.javiKotlinDev.pokeapicompose.ui.theme.darkGray
import es.javiKotlinDev.pokeapicompose.ui.theme.teal
import es.javiKotlinDev.pokeapicompose.ui.theme.transparent
import es.javiKotlinDev.pokeapicompose.ui.theme.white

@Composable
fun SearchPokemonScreen(
    viewModel: SearchPokemonViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    SearchPokemonView()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchPokemonView() {
    var text by remember { mutableStateOf(EMPTY_TEXT) }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(dark)
        .padding(bottom = 30.dp),
    ){
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                .background(white)
        ) {
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .height(150.dp)
                    .padding(start = 20.dp, top = 30.dp),
                painter = painterResource(id = R.drawable.pokemon),
                contentDescription = null)
            Column (
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 5.dp, top = 40.dp,end = 10.dp),
            ){
                Text(
                    text = "ID: 001",
                    fontSize = 14.sp,
                    color = teal,
                    maxLines = 1,
                )
                Text(
                    text = "NOMBRE DEL POKEMONnjj",
                    fontSize = 16.sp,
                    color = dark,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Tipo: ",
                        fontSize = 14.sp,
                        color = dark,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                    )
                    Text(
                        text = "Eléctrico",
                        fontSize = 14.sp,
                        color = dark,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Peso: ",
                        fontSize = 14.sp,
                        color = dark,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                    )
                    Text(
                        text = "weight",
                        fontSize = 14.sp,
                        color = dark,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 15.dp)
                .background(darkGray),
        ) {
            TextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 10.dp),
                value = text,
                onValueChange = { newText -> text = newText },
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
                onClick = { /*TODO*/ },
            ) {
                Text(text = "Search")
            }
        }
    }

}

@Preview
@Composable
private fun PreviewSearchScreen() {
    SearchPokemonView()
}