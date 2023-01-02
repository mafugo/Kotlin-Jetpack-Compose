package com.example.quadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrants.ui.theme.QuadrantsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrant()
                }
            }
        }
    }
}

@Composable
fun InfoCard(name: String,
             info: String,
             color: Color,
             modifier: Modifier) {

    Column(modifier = modifier
                .fillMaxSize()
                .padding(all = 16.dp)
                .background(color),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ){
        Text(text = name,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp))
        Text(text = info,
            textAlign = TextAlign.Justify)
    }
}

@Composable
fun ComposeQuadrant(){
    Column(modifier = Modifier.fillMaxWidth()){
        Row (Modifier.weight(1f)
                        .fillMaxSize()){
            InfoCard(
                name = stringResource(id = R.string.text_composable),
                info = stringResource(id = R.string.text_info),
                color = Color.Green,
                modifier = Modifier.weight(1f)
            )

            InfoCard(
                name = stringResource(id = R.string.image_composable),
                info = stringResource(id = R.string.image_info),
                color = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }

        Row (Modifier.weight(1f)
                        .fillMaxSize()){
            InfoCard(
                name = stringResource(id = R.string.row_composable),
                info = stringResource(id = R.string.row_info),
                color = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            InfoCard(
                name = stringResource(id = R.string.column_composable),
                info = stringResource(id = R.string.column_info),
                color = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuadrantsTheme {
        ComposeQuadrant()
    }
}