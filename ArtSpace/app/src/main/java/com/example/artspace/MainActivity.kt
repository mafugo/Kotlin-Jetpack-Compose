package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun ArtSpaceApp(){
    var currentArtwork by remember { mutableStateOf(1) }

    when(currentArtwork){
        1->
            Column(modifier = Modifier
                .fillMaxSize()
                .wrapContentSize()) {

                ArtWorkWall(
                    painterResourceId = R.drawable.europeana_5tk1f5vfdik_unsplash,
                    contentDescriptorId = R.string.photo_descriptor_1,
                    modifier =  Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                ArtWorkDescriptor(
                    title = "Europeana",
                    artistId = R.string.artist_1,
                    dateId = R.string.date_1
                )
                Spacer(modifier = Modifier.height(8.dp))
                DisplayController(
                    onClickPrev = {currentArtwork = 2},
                    onClickNext = {currentArtwork = 2})
            }
        2->
            Column(modifier = Modifier
                .fillMaxSize()
                .wrapContentSize()) {

                ArtWorkWall(
                    painterResourceId = R.drawable.adrianna_geo_1rbg5ysi00c_unsplash,
                    contentDescriptorId = R.string.photo_descriptor_2,
                    modifier =  Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                ArtWorkDescriptor(
                    title = "Michael Angelo's Work",
                    artistId = R.string.artist_2,
                    dateId = R.string.date_2
                )
                Spacer(modifier = Modifier.height(8.dp))
                DisplayController(
                    onClickPrev = {currentArtwork = 1},
                    onClickNext = {currentArtwork = 1})
            }
    }

}

@Composable
fun ArtWorkWall(
    painterResourceId: Int,
    contentDescriptorId: Int,
    modifier: Modifier
){
    Image(
        painter = painterResource(painterResourceId),
        contentDescription = stringResource(id = contentDescriptorId),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
fun ArtWorkDescriptor(
    title: String,
    artistId: Int,
    dateId: Int
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        )
        Row {
            Text(
                text = stringResource(id = artistId),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = dateId),
                fontWeight = FontWeight.Light)
        }

    }
}

@Composable
fun DisplayController(
    onClickPrev: ()->Unit,
    onClickNext: () -> Unit
){
    val configuration = LocalConfiguration.current

    val screenWidth = configuration.screenWidthDp.dp

    Row (horizontalArrangement = Arrangement.Center
    ){
        Button(
            onClick = onClickPrev,
            Modifier
                .width(150.dp)
                .absolutePadding(8.dp, 8.dp, 16.dp, 8.dp)
        ) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.width(screenWidth/4))
        Button(
            onClick = onClickNext ,
            Modifier
                .width(150.dp)
                .absolutePadding(16.dp, 8.dp, 8.dp, 8.dp)
        ) {
            Text(text = "Next")
        }
    }
}