package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

data class Wesen(
    val imageRes: Int,
    val name: String,
    val origin: String,
    val type: String
)

@Composable
fun ArtSpaceLayout() {
    val wesenList = listOf(
        Wesen(R.drawable.blutbad, "Blutbad", "Grimm - Oregon, USA", "Depredador"),
        Wesen(R.drawable.fuchsbau, "Fuchsbau", "Grimm - Oregon, USA", "Neutral"),
        Wesen(R.drawable.pflichttreue, "Pflichttreue", "Grimm - Oregon, USA", "Leal"),
        Wesen(R.drawable.scharfblicke, "Scharfblicke", "Grimm - Oregon, USA", "Observador"),
        Wesen(R.drawable.seelengut, "Seelengut", "Grimm - Oregon, USA", "Pacífico")
    )

    var currentIndex by remember { mutableStateOf(0) }
    val currentWesen = wesenList[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "🐺 Wesen Space",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        Box(
            modifier = Modifier
                .shadow(8.dp, RoundedCornerShape(16.dp))
                .background(Color.White, RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = currentWesen.imageRes),
                contentDescription = currentWesen.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(280.dp),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .background(Color(0xFFEEEEEE), RoundedCornerShape(12.dp))
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = currentWesen.name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = currentWesen.origin,
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            Text(
                text = currentWesen.type,
                fontSize = 14.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }

        Text(
            text = "${currentIndex + 1} / ${wesenList.size}",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    currentIndex = if (currentIndex == 0) wesenList.size - 1 else currentIndex - 1
                },
                modifier = Modifier.width(140.dp)
            ) {
                Text(text = "⬅ Anterior")
            }
            Button(
                onClick = {
                    currentIndex = if (currentIndex == wesenList.size - 1) 0 else currentIndex + 1
                },
                modifier = Modifier.width(140.dp)
            ) {
                Text(text = "Siguiente ➡")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceLayout()
    }
}