package com.example.mynote.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynote.R
import com.example.mynote.components.NoteTextfield
import com.example.mynote.components.Notebutton
import com.example.mynote.components.Noterow
import com.example.mynote.notemodel.Note


@ExperimentalComposeUiApi
@Composable fun Notescreen(noteslist:List<Note>,addnote:(Note)->Unit,
deletenote:(Note)->Unit){
    var title= remember {
        mutableStateOf("")
    }
    var description= remember {
        mutableStateOf("")
    }

    val context= LocalContext.current
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

    Column {
        TopAppBar(modifier = Modifier.padding(5.dp), backgroundColor = Color.LightGray,
    title={ Text(text = stringResource(id = R.string.app_name))},
    actions = { Icon(imageVector = Icons.Default.Notifications, contentDescription ="notification" )})
        NoteTextfield(text =title , label ="Title",
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = CenterHorizontally), textweight = FontWeight.Medium ,
        textsize = 23)
        NoteTextfield(text = description, label = "Add Note",
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), textsize = 20)
        Notebutton(onbuttonclick = {
                                   if(title.value.isNotEmpty() && description.value.isNotEmpty()){
                                       addnote(Note(title = title.value, description = description.value))
                                       title.value=""
                                       description.value=""
                                       Toast.makeText(context
                                           ,"Note Added",
                                       Toast.LENGTH_SHORT).show()

                                   }

        }, label ="Save",
            modifier = Modifier
                .padding(10.dp)
                .align(alignment = CenterHorizontally)
                .width(80.dp)
                .height(45.dp))
        Divider(modifier = Modifier.padding(10.dp))
        LazyColumn{
            items(noteslist){
                Noterow(note = it, onrowclick = {
                    deletenote(it)
                })

            }
        }
}}}

