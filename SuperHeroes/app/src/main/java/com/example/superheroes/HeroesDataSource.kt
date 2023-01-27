package com.example.superheroes

import SuperHeroesTheme
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.Typography


@Composable
fun SuperHeroScreen(heroList: List<Hero>, modifier: Modifier){
    LazyColumn(modifier = modifier){
        items(heroList) {
            SuperHeroListItem(hero = it, modifier = Modifier)
        }
    }
}

@Composable
fun SuperHeroListItem(hero: Hero, modifier: Modifier){
    Card(
        modifier = Modifier
            .padding(16.dp),
        elevation = 2.dp,
        shape = RoundedCornerShape(16.dp)

    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .sizeIn(minHeight = 72.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = stringResource(id = hero.nameRes) + stringResource(id = hero.descriptionRes),
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}

@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroListPreview(){
    SuperHeroesTheme{
        SuperHeroScreen(heroList = HeroesRepository.heroes, modifier = Modifier)
    }
}

