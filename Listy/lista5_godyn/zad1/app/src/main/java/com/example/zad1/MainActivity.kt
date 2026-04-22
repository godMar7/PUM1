package com.example.zad1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zad1.ui.theme.Zad1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Zad1Theme {
                // plotno(?) aplikacji
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterExample()
                }
            }
        }
    }
}

@Composable
fun CounterExample() {
    //rememberSaveable zapamietuje wartosc licznika nawet po obrocie ekranu
    var counter by rememberSaveable { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.weight(0.3f))
        Text(
            text = counter.toString(),
            fontSize = 250.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )

        // Przycisk RESET
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            shape = RectangleShape,
            onClick = { counter = 0 }
        ) {
            Text(text = "RESET")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 8.dp),
            // odstep miedzy przyciskami
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Przycisk COUNT UP
            Button(
                //weight(1f) zajmuje 50% dosgtepnego miejsca
                modifier = Modifier.weight(1f),
                shape = RectangleShape,
                onClick = { counter++ }
            ) {
                Text(text = "COUNT UP")
            }

            // Przycisk COUNT DOWN
            Button(
                modifier = Modifier.weight(1f),
                shape = RectangleShape,
                onClick = { counter-- }
            ) {
                Text(text = "COUNT DOWN")
            }
        }
    }
}