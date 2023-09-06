package com.example.myappfsb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myappfsb.ui.theme.MyAppFSBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppFSBTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Llama a tu Composable personalizado para la actividad principal
                    MyActivityContent()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyActivityContent() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // EditText para el primer número
        OutlinedTextField(
            value = text1,
            onValueChange = { text1 = it },
            label = { Text("Ingrese el primer número") }
        )

        // EditText para el segundo número
        OutlinedTextField(
            value = text2,
            onValueChange = { text2 = it },
            label = { Text("Ingrese el segundo número") }
        )

        // Botón para comparar
        Button(
            onClick = {
                val num1 = text1.toDoubleOrNull()
                val num2 = text2.toDoubleOrNull()

                if (num1 != null && num2 != null) {
                    result = when {
                        num1 < num2 -> "$num1 es menor que $num2"
                        num1 > num2 -> "$num1 es mayor que $num2"
                        else -> "$num1 es igual a $num2"
                    }
                } else {
                    result = "Por favor, ingrese números válidos en ambos campos."
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Comparar")
        }

        // TextView para mostrar el resultado
        Text(
            text = result,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyActivityPreview() {
    MyAppFSBTheme {
        MyActivityContent()
    }
}
