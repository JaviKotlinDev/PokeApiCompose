package es.javiKotlinDev.pokeapicompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import es.javiKotlinDev.pokeapicompose.ui.navigation.NavigationHost
import es.javiKotlinDev.pokeapicompose.ui.theme.PokeApiComposeTheme

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeApiComposeTheme {
                NavigationHost()
            }
        }
    }

}