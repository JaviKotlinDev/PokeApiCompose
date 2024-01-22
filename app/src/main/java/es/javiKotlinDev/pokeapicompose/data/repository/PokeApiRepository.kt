package es.javiKotlinDev.pokeapicompose.data.repository

import es.javiKotlinDev.pokeapicompose.data.dataSource.PokeApiDataSource
import es.javiKotlinDev.pokeapicompose.data.domain.PokemonDomain
import es.javiKotlinDev.pokeapicompose.data.error.RepositoryErrorManager
import es.javiKotlinDev.pokeapicompose.data.response.AsyncResult
import kotlinx.coroutines.flow.Flow

interface PokeApiRepository {
    suspend fun getPokemonByIdOrName(idOrName: String): Flow<AsyncResult<PokemonDomain>>

}

class PokeApiRepositoryImpl(
    private val dataSource: PokeApiDataSource,
    private val repositoryErrorManager: RepositoryErrorManager
): PokeApiRepository {
    override suspend fun getPokemonByIdOrName(idOrName: String): Flow<AsyncResult<PokemonDomain>> =
        repositoryErrorManager.wrap {
            dataSource.getPokemonByIdOrName(idOrName)
        }

}