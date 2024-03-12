package com.example.mynote.data

import com.example.mynote.notemodel.Note

class Dummydata{
    fun loaddata():List<Note>{
        return listOf(Note(title = "Note 1", description = "This is a dummy note"),
            Note(title = "Note 2", description = "this is another example of note")
        )
    }
}