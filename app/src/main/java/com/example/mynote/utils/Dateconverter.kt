package com.example.mynote.utils

import androidx.room.TypeConverter
import java.util.Date

class Dateconverter {
    @TypeConverter
    fun datetotime(date:Date):Long{
        return date.time
    }

    @TypeConverter
    fun timetodate(time:Long):Date{
        return Date(time)
    }
}