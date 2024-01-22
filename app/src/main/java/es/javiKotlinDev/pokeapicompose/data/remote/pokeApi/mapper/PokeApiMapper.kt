package es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.mapper

import es.javiKotlinDev.pokeapicompose.data.domain.PokemonDomain
import es.javiKotlinDev.pokeapicompose.data.domain.SpritesDomain
import es.javiKotlinDev.pokeapicompose.data.domain.StatsDomain
import es.javiKotlinDev.pokeapicompose.data.domain.TypeDomain
import es.javiKotlinDev.pokeapicompose.data.domain.TypesDomain
import es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.dto.PokemonDTO
import es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.dto.SpritesDTO
import es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.dto.StatsDTO
import es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.dto.TypeDTO
import es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.dto.TypesDTO
import es.javiKotlinDev.pokeapicompose.utils.isFalse
import es.javiKotlinDev.pokeapicompose.utils.orZero

fun PokemonDTO.toDomain() = PokemonDomain(
    id = id.orZero(),
    name = name.orEmpty(),
    types = types?.mapNotNull { it?.toDomain() }.orEmpty(),
    weight = weight.orZero(),
    height = height.orZero(),
    sprites = sprites?.toDomain() ?: SpritesDomain(),
    stats = stats?.mapNotNull { it?.toDomain() }.orEmpty(),
    baseExperience = baseExperience.orZero(),
    isDefault = isDefault.isFalse(),
)

fun TypesDTO.toDomain() = TypesDomain(
    slot = slot.orZero(),
    type = type?.toDomain() ?: TypeDomain()
)
fun TypeDTO.toDomain() = TypeDomain(
    name = name.orEmpty()
)

fun SpritesDTO.toDomain() = SpritesDomain(
    frontDefault = frontDefault.orEmpty(),
    frontShiny = frontShiny.orEmpty()
)

fun StatsDTO.toDomain() = StatsDomain(
    baseStat = baseStat.orZero()
)
