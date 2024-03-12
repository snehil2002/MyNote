package com.example.mynote.utils

import java.text.SimpleDateFormat
import java.util.*

fun Dateformat(date: Date):String{
    val format=SimpleDateFormat("EEE,d MMM hh:mm aaa",
    Locale.getDefault()
    )
    return format.format(date)

}