package com.example.pokeapicompose.utils

fun capitalizeFirstLetter(str: String): String =
    if (str.isNotEmpty()) {
        str.substring(0, 1).uppercase() + str.substring(1)

    } else {
        str
    }

fun toTitleCase(str: String): String {
    return str.split(" ").joinToString(" ") { capitalizeFirstLetter(it) }
}

fun isNumber(str: String): Boolean = str.toIntOrNull() != null

fun isDecimal(str: String): Boolean = str.toDoubleOrNull() != null

