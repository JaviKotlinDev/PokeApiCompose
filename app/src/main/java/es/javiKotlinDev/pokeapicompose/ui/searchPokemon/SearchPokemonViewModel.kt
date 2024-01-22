package es.javiKotlinDev.pokeapicompose.ui.searchPokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.javiKotlinDev.pokeapicompose.data.domain.PokemonDomain
import es.javiKotlinDev.pokeapicompose.data.domain.SearchPokemonUseCase
import es.javiKotlinDev.pokeapicompose.data.response.AsyncResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class SearchPokemonViewModel@Inject constructor(
    private val searchPokemonUseCase: SearchPokemonUseCase,
): ViewModel() {

    private val searchPokemonLiveData = MutableLiveData<AsyncResult<PokemonDomain>>()
    fun getSearchPokemonLiveData(): LiveData<AsyncResult<PokemonDomain>> = searchPokemonLiveData

    fun searchPokemon(idOrName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            searchPokemonUseCase.invoke(idOrName.lowercase(Locale.ROOT)).collect {
                searchPokemonLiveData.postValue(it)
            }
        }
    }
}