package com.example.mynote.utils

import androidx.room.TypeConverter
import java.util.UUID

class UUIDconverter {
    @TypeConverter fun uuidtostring(uuid:UUID):String{
        return uuid.toString()
    }

    @TypeConverter fun stringtouuid(string: String):UUID{
        return UUID.fromString(string)
    }
}