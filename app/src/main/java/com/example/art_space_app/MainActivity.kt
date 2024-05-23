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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
        .background(color = Color.White),
    ){
        Image(
            painter = painterResource(picture),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
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
        .padding(20.dp)
        .fillMaxWidth(1f)
    ) {
        Text(text = stringResource(id = des),
            fontSize = 25.sp,
        )
        Text(text = stringResource(id = autor),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun Buttons(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(CornerSize(15.dp)),
            modifier = Modifier
                .weight(0.5f, false)
            ) {
            Text(text = "Previous")

        }

        Button(onClick = { /*TODO*/ },
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            modifier = Modifier
                .weight(0.4f, true)
        ) {
            Text(text = "Next")
        }
    }
}

@Composable
fun ArtSpace(name: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
        ) {
        Artwork(picture = R.drawable.latarnia,
            modifier = Modifier.padding(20.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        ArtworkDes(des = R.string.latarnia_des,
            autor = R.string.latarnia_autor,
            modifier = Modifier.padding(20.dp)
        )

        Buttons(modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    Art_Space_appTheme {
        ArtSpace("Android")
    }
}