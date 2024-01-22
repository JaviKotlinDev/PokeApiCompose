package es.javiKotlinDev.pokeapicompose.data.remote.pokeApi

import es.javiKotlinDev.pokeapicompose.data.dataSource.PokeApiDataSource
import es.javiKotlinDev.pokeapicompose.data.domain.PokemonDomain
import es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.mapper.toDomain

class PokeApiDataSourceImpl(private val service: PokeApiService): PokeApiDataSource {

    override suspend fun getPokemonByIdOrName(idOrName: String): PokemonDomain =
        service.getPokemonByIdOrName(idOrName).toDomain()


}