package es.javiKotlinDev.pokeapicompose.utils

fun Float?.orZero() = this ?: 0f

fun Double?.orZero(): Double = this ?: 0.0

fun Int?.orZero() = this ?: 0

fun Long?.orZero() = this ?: 0L