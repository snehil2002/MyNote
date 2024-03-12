package com.example.mynote

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynote.screens.Notescreen
import com.example.mynote.screens.NoteViewmodel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val noteviewmodel= viewModel<NoteViewmodel>()

            MyNoteApp(noteviewmodel = noteviewmodel)

        }
    }
}


@ExperimentalComposeUiApi
@Composable fun MyNoteApp(noteviewmodel:NoteViewmodel= viewModel()){

    Notescreen(noteslist = noteviewmodel.notelist.collectAsState().value, addnote ={
        noteviewmodel.addnote(it)
    }, deletenote = {noteviewmodel.deletenote(it)})
}



