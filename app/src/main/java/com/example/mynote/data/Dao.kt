package com.example.mynote.data

import androidx.room.*
import com.example.mynote.notemodel.Note
import com.example.mynote.utils.Dateconverter
import com.example.mynote.utils.UUIDconverter
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@androidx.room.Dao
@TypeConverters(Dateconverter::class,UUIDconverter::class)
interface Dao {

    @Query("SELECT * from Note ORDER BY entrydate DESC")
    fun getallnotes():Flow<List<Note>>

    @Query("SELECT * from Note where id=:id")
    suspend fun getnotebyid(id:String):Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note:Note)

    @Delete
    suspend fun delete(note:Note)

    @Query("DELETE from Note")
    suspend fun deleteall()

}