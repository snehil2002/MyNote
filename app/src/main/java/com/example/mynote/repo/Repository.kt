package com.example.mynote.repo

import com.example.mynote.data.Dao
import com.example.mynote.notemodel.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class Repository @Inject constructor(private val dao:Dao) {
    suspend fun  addnote(note: Note){
        dao.insert(note)
    }
    suspend fun deletenode(note:Note){
        dao.delete(note)
    }
    suspend fun updatenote(note:Note){
        dao.update(note)
    }
    suspend fun deleteallnotes(){
        dao.deleteall()
    }
    suspend fun getallnotes(): Flow<List<Note>> {
        return dao.getallnotes().flowOn(Dispatchers.IO).conflate()
    }
}