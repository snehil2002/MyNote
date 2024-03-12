package com.example.mynote.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynote.notemodel.Note
import com.example.mynote.utils.Dateformat
import java.time.format.DateTimeFormatter

@ExperimentalComposeUiApi
@Composable fun NoteTextfield(text:MutableState<String>, modifier:Modifier=Modifier,
                              label:String,textweight:FontWeight=FontWeight.Normal,
textsize:Int){
    val keyboardcontroller=LocalSoftwareKeyboardController.current
    TextField(
        value = text.value, onValueChange = { text.value = it }, enabled = true,
        modifier = modifier, label = { Text(text = label, fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold) },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {keyboardcontroller?.hide()}),
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        textStyle = TextStyle(fontSize = textsize.sp, fontWeight = textweight)

    )
}

@Composable fun Notebutton(onbuttonclick:()->Unit,modifier: Modifier=Modifier,label:String){
    Button(onClick = onbuttonclick, shape = RoundedCornerShape(30.dp), modifier = modifier,
    elevation = ButtonDefaults.elevation(5.dp), enabled = true) {
        Text(text = label)

    }
}

@Composable fun Noterow(note: Note, onrowclick:()->Unit){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .clip(shape = RoundedCornerShape(topEnd = 20.dp, bottomStart = 20.dp)).
        clickable{onrowclick()},
        color = Color(0xFFCAD1F8)
    ) {
        Column() {
            Text(text = note.title, modifier = Modifier.
            padding(vertical = 2.dp, horizontal = 10.dp),
                fontWeight = FontWeight.Bold, fontSize = 23.sp)
            Text(text = note.description, modifier = Modifier.
            padding(vertical = 2.dp, horizontal = 10.dp),
                fontSize =21.sp )
            Text(text = Dateformat(note.entrydate) , modifier = Modifier.
            padding(vertical = 2.dp, horizontal = 10.dp),
                fontSize =18.sp, fontWeight = FontWeight.Light )

        }

    }
}

