package es.javiKotlinDev.pokeapicompose.data.domain

import es.javiKotlinDev.pokeapicompose.data.repository.PokeApiRepository
import es.javiKotlinDev.pokeapicompose.data.response.AsyncResult
import kotlinx.coroutines.flow.Flow

interface SearchPokemonUseCase {
    suspend operator fun invoke(idOrName: String): Flow<AsyncResult<PokemonDomain>>

}

class SearchPokemonUseCaseImpl(
    private val repository: PokeApiRepository
): SearchPokemonUseCase {
    override suspend fun invoke(idOrName: String): Flow<AsyncResult<PokemonDomain>> =
        repository.getPokemonByIdOrName(idOrName)
}