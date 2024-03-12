package com.example.mynote.data

import androidx.room.Database
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mynote.notemodel.Note
import com.example.mynote.utils.Dateconverter
import com.example.mynote.utils.UUIDconverter
import kotlinx.coroutines.flow.Flow

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(Dateconverter::class,UUIDconverter::class)
abstract class Roomdatabase : RoomDatabase() {
abstract fun notedao():Dao
}