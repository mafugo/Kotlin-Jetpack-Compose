package com.example.superheroes

import SuperHeroesTheme
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.HeroesRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SuperHeroApp()
                }
            }
        }
    }
}

@Composable
fun TopAppBar(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp),
    contentAlignment = Alignment.Center) {
            Text(text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1)
    }
}


@Composable
fun SuperHeroApp(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar ={TopAppBar()} ) {

        SuperHeroScreen(heroList = HeroesRepository.heroes, modifier = Modifier)
    }

}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SuperHeroPreview(){
    SuperHeroesTheme{
        TopAppBar()
        SuperHeroScreen(heroList = HeroesRepository.heroes, modifier = Modifier)
    }
}