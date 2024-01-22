package es.javiKotlinDev.pokeapicompose.data.remote.pokeApi

import es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.dto.PokemonDTO
import retrofit2.http.GET
import retrofit2.http.Path


interface PokeApiService {
     @GET("pokemon/{idOrName}")
     suspend fun getPokemonByIdOrName(@Path("idOrName") idOrName: String): PokemonDTO

}