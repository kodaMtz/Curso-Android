package com.example.cuadrantecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadrantes.R
import com.example.cuadrantes.ui.theme.CuadrantesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CuadrantesTheme() {
                ComposeQuadrantScreen()
            }
        }
    }
}

// Este es un solo cuadrante (lo reutilizamos 4 veces)
@Composable
fun ComposeCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        // Centra el contenido vertical y horizontalmente
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)  // padding en los 4 lados
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,       // negrita
            modifier = Modifier.padding(bottom = 16.dp)  // padding inferior
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify       // texto justificado
        )
    }
}

// 👇 Esta es la pantalla completa con los 4 cuadrantes
@Composable
fun ComposeQuadrantScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

        // ── Fila de ARRIBA (cuadrante 1 y 2) ──
        Row(modifier = Modifier.weight(1f)) {  // ocupa 50% de la altura

            ComposeCard(
                title = stringResource(R.string.title_composable),
                description = stringResource(R.string.parrafo_text),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)  // ocupa 50% del ancho
            )

            ComposeCard(
                title = stringResource(R.string.title_image),
                description = stringResource(R.string.parrafo_image),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)  // ocupa 50% del ancho
            )
        }

        // ── Fila de ABAJO (cuadrante 3 y 4) ──
        Row(modifier = Modifier.weight(1f)) {  // ocupa 50% de la altura

            ComposeCard(
                title = stringResource(R.string.title_row),
                description = stringResource(R.string.parrafo_row),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )

            ComposeCard(
                title = stringResource(R.string.title_column),
                description = stringResource(R.string.Parrafo_4),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    CuadrantesTheme {
        ComposeQuadrantScreen()
    }
}