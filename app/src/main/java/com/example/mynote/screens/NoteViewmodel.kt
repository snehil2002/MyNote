package com.example.mynote.screens

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynote.data.Dummydata
import com.example.mynote.notemodel.Note
import com.example.mynote.repo.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewmodel @Inject constructor(private val repository: Repository):ViewModel() {
    private val notelist_ = MutableStateFlow<List<Note>>(emptyList())
    val notelist=notelist_.asStateFlow()
    init{
        viewModelScope.launch(Dispatchers.IO){
            repository.getallnotes().distinctUntilChanged().collect{

                    notelist_.value=it

            }
        }
    }
    fun addnote(note: Note){
        viewModelScope.launch { repository.addnote(note) }
    }
    fun deletenote(note:Note){
        viewModelScope.launch { repository.deletenode(note) }
    }




}