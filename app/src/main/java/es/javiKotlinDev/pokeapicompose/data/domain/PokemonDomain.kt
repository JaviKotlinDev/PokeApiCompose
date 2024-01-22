package es.javiKotlinDev.pokeapicompose.data.domain

import es.javiKotlinDev.pokeapicompose.constans.PokeApiConstants

data class PokemonDomain(
    val id: Int,
    val name: String,
    val types: List<TypesDomain>,
    val weight: Int,
    val height: Int,
    val stats: List<StatsDomain>,
    val sprites: SpritesDomain,
    val baseExperience: Int,
    val isDefault: Boolean
)

data class TypesDomain(
    val slot: Int,
    val type: TypeDomain
)

data class TypeDomain(
    val name: String = PokeApiConstants.EMPTY_TEXT
)

data class SpritesDomain(
    val frontDefault: String = PokeApiConstants.EMPTY_TEXT,
    val frontShiny: String = PokeApiConstants.EMPTY_TEXT,
)

data class StatsDomain(
    val baseStat: Int = PokeApiConstants.ZERO
)