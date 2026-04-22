package com.example.zad2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zad2.ui.theme.Zad2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Zad2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Kalkulator()
                }
            }
        }
    }
}

@Composable
fun Kalkulator() {
    // rememberSaveable by dane nie znikaly przy obracaniu
    var liczba1 by rememberSaveable { mutableStateOf("") }
    var liczba2 by rememberSaveable { mutableStateOf("") }
    var wynik by rememberSaveable { mutableStateOf("N/A") }

    fun wykonajObliczenie(operacja: String) {
        val n1 = liczba1.toIntOrNull()
        val n2 = liczba2.toIntOrNull()

        if (n1 == null || n2 == null) {
            wynik = "Błąd wprowadzania"
            return
        }

        wynik = when (operacja) {
            "+" -> (n1 + n2).toString()
            "-" -> (n1 - n2).toString()
            "*" -> (n1 * n2).toString()
            "/" -> {
                if (n2 == 0) "Nie dziel przez 0!" else (n1 / n2).toString()
            }
            else -> "N/A"
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // pierwsze pole tekstowe
        TextField(
            value = liczba1,
            onValueChange = { liczba1 = it },
            placeholder = { Text("Enter first number") },
            // wymuszenie klawiatury numerycznej
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // drugie pole tekstowe
        TextField(
            value = liczba2,
            onValueChange = { liczba2 = it },
            placeholder = { Text("Enter second number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            // przyciski wywolujace funkcje z odpowiednia operacja
            Button(onClick = { wykonajObliczenie("+") }, shape = RectangleShape) { Text("+") }
            Button(onClick = { wykonajObliczenie("-") }, shape = RectangleShape) { Text("-") }
            Button(onClick = { wykonajObliczenie("*") }, shape = RectangleShape) { Text("×") }
            Button(onClick = { wykonajObliczenie("/") }, shape = RectangleShape) { Text("÷") }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Result: $wynik",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}