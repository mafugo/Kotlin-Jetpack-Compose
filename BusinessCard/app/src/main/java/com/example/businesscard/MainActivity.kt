package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun LogoNameTitle(name: String, title: String){
    val image = painterResource(id = R.drawable.android_logo)
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {

        Image(
            painter = image,
            contentDescription = "Android logo",
            modifier = Modifier
                .padding(16.dp)
        )

        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            fontStyle = FontStyle(0),
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign . Center,
            color = Color.White,
            modifier = Modifier
                .padding(12.dp)
        )

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            textAlign = TextAlign.Justify,
            color = Color.Green,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
fun ContactInfo(phoneNo: String, socialMediaHandler: String, email: String){
    val phoneIcon = Icons.Rounded.Phone
    val emailIcon = Icons.Rounded.Email
    val socialMediaIcon = Icons.Rounded.Share
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.fillMaxWidth())
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.align(Alignment.Start)
        )
        {
            Icon(
                imageVector = phoneIcon,
                contentDescription = "Phone Icon",
                tint = Color.White
            )
            Text(
                text = phoneNo,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.fillMaxWidth())
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(
                imageVector = socialMediaIcon,
                contentDescription = "Social Media Icon",
                tint = Color.White
            )
            Text(
                text = socialMediaHandler,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.fillMaxWidth())
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(
                imageVector = emailIcon,
                contentDescription = "Email Icon",
                tint = Color.White
            )
            Text(
                text = email,
                fontSize = 16.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun BusinessCardApp(){
    Column {

        LogoNameTitle(
            name = "M. Furkan Gön",
            title = "CS Major, Software Enthusiast"
        )
        ContactInfo(
            phoneNo = "+90 553 316 86 16",
            socialMediaHandler = "@mfurkangon",
            email = "mahmutfurkangon16400@gmail.cım"
        )
    }
}
@Preview
@Composable
fun FullScreen(){
    BusinessCardTheme{
        BusinessCardApp()
    }
}