package com.example.basiccompose_week2_acc

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeetToMetres()
        }
    }

    @Composable
    fun HelloComposable() { // Simple Composable
        Text("Hello World from the Composable!")
    }

    @Composable
    fun TwoTexts() {
        Column { //Column arranges vertically. Row arranges horizontally.
            Text("Hello World!")
            Text("Welcome to Android Development")
        }
    }

    @Composable
    fun TwoTextsStyled() { // Styled Text
        Column {
            Text("Hello World!", color = Color.Red, fontStyle=FontStyle.Italic, fontFamily=FontFamily.Serif)
            Text("Welcome to Android Development", fontWeight=FontWeight.Bold)
        }
    }

    @Composable
    fun StringXML() {// Retrieves string from strings.xml file in 'res/values/strings.xml'
        Column {
            Text(resources.getString(R.string.helloworldGreek), color = Color.Red, fontStyle=FontStyle.Italic, fontFamily=FontFamily.Serif)
            Text("Welcome to Android Development", fontWeight=FontWeight.Bold)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun GreetingBox() { // Using what the user types in
        var name by remember { mutableStateOf("") }
        Column {
            TextField(value = name, onValueChange={name=it})// value = current value, onValueChange = changing value to what was entered.
            Text("Hello $name")// '$' for a variable
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ButtonUseChangeText() { // Do something when button is pressed
        var name by remember { mutableStateOf("") } // Read in change on TextField
        var newName by remember{mutableStateOf("")} // Change what is printed
        Column{
            TextField(value = name, onValueChange = {name=it}) // Text field for entry
            Button ( // Button creation
                onClick = {newName = name} // When pressed, printed text changed to match TextField
                    ){Text("Update Greeting")} // What is shown on button
        Text("Hello $newName")} // Prints updated Name

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FeetToMetres(){ // Everything together
        var feet by remember{ mutableStateOf(0.0) }
        var FeetInt = feet.toInt()
        var MetresInt = FeetInt*0.305
        var Metres = MetresInt.toString()
        Column {
            TextField(value = "$feet", onValueChange = {feet=it.toDouble()})
            Button(
                onClick = {feet=0.0}
            ){"Clear Entry"}
            Text("Metres $Metres")
        }
    }

}