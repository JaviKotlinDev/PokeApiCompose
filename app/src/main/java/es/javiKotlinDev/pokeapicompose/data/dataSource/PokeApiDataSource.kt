package es.javiKotlinDev.pokeapicompose.data.dataSource

import es.javiKotlinDev.pokeapicompose.data.domain.PokemonDomain

interface PokeApiDataSource {
    suspend fun getPokemonByIdOrName(idOrName: String): PokemonDomain

}