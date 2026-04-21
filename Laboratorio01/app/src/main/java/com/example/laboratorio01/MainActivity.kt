package com.example.laboratorio01

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio01.ui.theme.Laboratorio01Theme
import androidx.compose.runtime.*
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Laboratorio01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ListaTareas()
                    }
                }
            }
        }
    }
}


@Composable
fun Titulo(texto: String, modifier: Modifier = Modifier){
    Text(
        text = texto,
        modifier = modifier,
        fontSize = 30.sp,
        color = Color.Red
    )
}

@Composable
fun Subtitulo(texto: String, modifier: Modifier = Modifier){
    Text(
        text = texto,
        modifier = modifier,
        fontSize = 20.sp,
        color = Color.Blue
    )
}

@Composable
fun Button() {

    var grande by remember { mutableStateOf(false) }

    OutlinedButton(
        onClick = { grande = !grande },
        modifier = Modifier.size(
            if (grande) 200.dp else 120.dp
        ),
        shape = RoundedCornerShape(20.dp),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 2.dp
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.White,
            containerColor = Color(0xFF6200EE)
        )
    ) {
        Text("Presionar")

    }
}

@Composable
fun TarjetaInfo(
    titulo: String,
    subtitulo: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Titulo(titulo)

        Subtitulo(subtitulo)

        Button()
    }
}

data class Tarea(
    val titulo: String,
    val descripcion: String
)

@Composable
fun ListaTareas() {

    val lista = listOf(
        Tarea("Estudiar Kotlin", "Practicar Jetpack Compose"),
        Tarea("Hacer tarea", "Completar laboratorio Android"),
        Tarea("Comprar", "Laptop y mouse"),
        Tarea("Reunión", "Proyecto de software 3pm"),
        Tarea("Ejercicio", "Salir a correr 30 min")
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(lista) { tarea ->
            ItemCard(tarea)
        }
    }
}

@Composable
fun ItemCard(tarea: Tarea) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = tarea.titulo,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = tarea.descripcion,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLista() {
    Laboratorio01Theme {
        ListaTareas()
    }
}
