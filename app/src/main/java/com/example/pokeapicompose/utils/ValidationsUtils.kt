package com.example.pokeapicompose.utils

fun String.isValidEmail() =
    Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$").containsMatchIn(this)