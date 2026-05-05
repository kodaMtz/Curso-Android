package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp() {
    // Paso actual de la app (1, 2, 3 o 4)
    var currentStep by remember { mutableStateOf(1) }

    // Cuántas veces hay que presionar el limón (número aleatorio entre 2 y 4)
    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color(0xFFFFEB3B) // amarillo limonada
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            // Según el paso actual mostramos imagen y texto diferente
            when (currentStep) {
                1 -> LemonTextAndImage(
                    textId = R.string.lemon_select,
                    imageId = R.drawable.lemon_tree,
                    contentDescriptionId = R.string.lemon_tree_content_description,
                    onImageClick = {
                        currentStep = 2
                        // Generamos cuántas veces hay que exprimir el limón
                        squeezeCount = (2..4).random()
                    }
                )
                2 -> LemonTextAndImage(
                    textId = R.string.lemon_squeeze,
                    imageId = R.drawable.lemon_squeeze,
                    contentDescriptionId = R.string.lemon_content_description,
                    onImageClick = {
                        // Cada tap resta uno al contador
                        squeezeCount--
                        // Cuando llega a 0 pasamos al siguiente paso
                        if (squeezeCount == 0) {
                            currentStep = 3
                        }
                    }
                )
                3 -> LemonTextAndImage(
                    textId = R.string.lemon_drink,
                    imageId = R.drawable.lemon_drink,
                    contentDescriptionId = R.string.lemonade_content_description,
                    onImageClick = {
                        currentStep = 4
                    }
                )
                4 -> LemonTextAndImage(
                    textId = R.string.lemon_restart,
                    imageId = R.drawable.lemon_restart,
                    contentDescriptionId = R.string.empty_glass_content_description,
                    onImageClick = {
                        currentStep = 1
                    }
                )
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    textId: Int,
    imageId: Int,
    contentDescriptionId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        // Texto descriptivo del paso actual
        Text(
            text = stringResource(textId),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Imagen con borde redondeado y color de fondo destacado
        Image(
            painter = painterResource(imageId),
            contentDescription = stringResource(contentDescriptionId),
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(4.dp))
                .background(Color(0xFFC3ECD2)) // verde suave
                .clickable(onClick = onImageClick)
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}