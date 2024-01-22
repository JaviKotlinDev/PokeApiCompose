package es.javiKotlinDev.pokeapicompose.data.remote.pokeApi.dto

import com.google.gson.annotations.SerializedName

data class PokemonDTO(
    @SerializedName("order")
    val id: Int?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("types")
    val types: List<TypesDTO?>?,

    @SerializedName("weight")
    val weight: Int?,

    @SerializedName("height")
    val height: Int?,

    @SerializedName("stats")
    val stats: List<StatsDTO?>?,

    @SerializedName("sprites")
    val sprites: SpritesDTO?,

    @SerializedName("base_experience")
    val baseExperience: Int?,

    @SerializedName("is_default")
    val isDefault: Boolean?
)

data class TypesDTO(
    @SerializedName("slot")
    val slot: Int?,

    @SerializedName("type")
    val type: TypeDTO?
)

data class TypeDTO(
    @SerializedName("name")
    val name: String?
)

data class SpritesDTO(
    @SerializedName("front_default")
    val frontDefault: String?,

    @SerializedName("front_shiny")
    val frontShiny: String?
)

data class StatsDTO(
    @SerializedName("base_stat")
    val baseStat: Int?,
)