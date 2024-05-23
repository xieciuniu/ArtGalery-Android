package com.example.art_space_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art_space_app.ui.theme.Art_Space_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Art_Space_appTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpace(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Artwork(
    @DrawableRes picture: Int,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier
        .shadow(elevation = 10.dp)
        .background(color = Color.White)
//        .fillMaxWidth(0.8f),

    ){
        Image(
            painter = painterResource(picture),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp),
//                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ArtworkDes(@StringRes des: Int,
               @StringRes autor: Int,
               modifier: Modifier = Modifier
){


    Column(modifier = modifier
        .background(color = Color.LightGray, shape = RoundedCornerShape(CornerSize(10.dp)))
        .padding(15.dp)
        .padding(horizontal = 60.dp)
//        .fillMaxWidth(1f)
    ) {
        Text(text = stringResource(id = des),
            fontSize = 30.sp,
        )
        Text(text = stringResource(id = autor),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Buttons(next:()-> Unit,prev:() -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = { prev() },
            shape = RoundedCornerShape(CornerSize(15.dp)),
            modifier = Modifier
                .weight(1f, false)
//                .height(20.dp)
            ) {
            Text(text = "Previous")

        }

        Button(onClick = { next() },
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            modifier = Modifier
                .weight(0.4f, true)
//                .height(20.dp)
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun ArtSpace(name: String, modifier: Modifier = Modifier) {

    val painters = listOf(R.drawable.mona, R.drawable.gwiazdozbior, R.drawable.krzyk, R.drawable.dziewczyna, R.drawable.narodziny)
    val names = listOf(R.string.leonardoDaVinci, R.string.vincentVanGogh, R.string.edvardMunch, R.string.johannesVermeer, R.string.sandroBotticelli)
    val titles = listOf(R.string.monaLisa, R.string.gwizdozbior, R.string.krzyk, R.string.dziewczynaZPerla, R.string.narodzinyWenus)

    var painterNumber by remember { mutableIntStateOf(0) }

    Column(verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
        ) {

        Artwork(picture = painters[painterNumber],
            modifier = Modifier.padding(20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        ArtworkDes(des = titles[painterNumber],
            autor = names[painterNumber],
            modifier = Modifier.padding(20.dp)
        )

        Buttons(next = {
            if (painterNumber < painters.count() - 1) {
                painterNumber++
            } else { painterNumber = 0}
                       },
            prev = { if (painterNumber > 0) {
                painterNumber--
            } else {
                painterNumber = painters.count() - 1
            }
                   },
            modifier = Modifier.padding(horizontal = 20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    Art_Space_appTheme {
        ArtSpace("Android")
    }
}