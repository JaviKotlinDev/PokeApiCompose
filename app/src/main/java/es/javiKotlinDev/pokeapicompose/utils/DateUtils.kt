package es.javiKotlinDev.pokeapicompose.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val DATE_FORMAT = "dd/MM/yyyy"
private val dateFormatter = SimpleDateFormat(DATE_FORMAT, Locale.ROOT)

fun String.toDate(): Date = dateFormatter.parse(this) ?: Date()

fun Date.toStringFormatted(): String = dateFormatter.format(this)

fun getDateFormatted(day: Int, month: Int, year: Int): String =
    "$day/$month/$year".toDate().toStringFormatted()