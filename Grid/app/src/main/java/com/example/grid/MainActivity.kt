package com.example.grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.grid.dataSource.DataSource
import com.example.grid.model.Topic
import com.example.grid.ui.theme.GridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TopicGrid(modifier = Modifier)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicGrid(modifier: Modifier){
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(8.dp)
    ){
        items(DataSource.topics){
            item: Topic ->  TopicCard(topic = item, modifier = Modifier)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier){
    Card(elevation = 4.dp) {
        Row {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                modifier = Modifier.size(68.dp, 68.dp),
                contentScale = ContentScale.Crop
            )
            Column (modifier = Modifier.padding(start = 16.dp)){
                Text(
                    text = stringResource(id = topic.stringResourceId),
                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 8.dp, end = 16.dp)
                )
                Row(modifier = Modifier.padding(bottom = 8.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = "Grain Icon",
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(12.dp)
                    )
                    Text(text = topic.associatedCourses.toString(),
                        style = MaterialTheme.typography.caption,)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopicCardPreview(){
    TopicGrid(modifier = Modifier)
}