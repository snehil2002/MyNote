package com.example.mynote.notemodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID

@Entity
data class Note(
    @PrimaryKey
    val id:UUID=UUID.randomUUID(),
    @ColumnInfo
    val title : String,
    @ColumnInfo
    val description:String,
    @ColumnInfo
    val entrydate:Date=Date.from(Instant.now()))