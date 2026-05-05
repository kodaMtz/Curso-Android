package com.example.administradortareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.administradortareas.ui.theme.AdministradorTareasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdministradorTareasTheme {
                TasksCompletedScreen()
            }
        }
    }
}

@Composable
fun TasksCompletedScreen(modifier: Modifier = Modifier) {
    Column(
        // Esto centra todo el contenido vertical y horizontalmente
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,       // centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally  // centra horizontalmente
    ) {

        // ️La imagen del check verde
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null
        )

        // Texto principal: negrita, padding top 24dp, padding bottom 8dp
        Text(
            text = stringResource(R.string.all_tasks_text),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )

        // Texto secundario: tamaño 16sp
        Text(
            text = stringResource(R.string.nice_work_text),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TasksCompletedPreview() {
    AdministradorTareasTheme {
        TasksCompletedScreen()
    }
}