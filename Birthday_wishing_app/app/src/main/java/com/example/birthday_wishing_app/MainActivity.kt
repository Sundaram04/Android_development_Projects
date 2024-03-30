package com.example.birthday_wishing_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthday_wishing_app.ui.theme.Birthday_wishing_appTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Birthday_wishing_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text)
                    )
                }
            }
        }
    }
}

// This GreetingText() function displays text in the UI.
// It does so by calling the Text() composable function.

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Birthday Message Text composable
    Column(
        // The alignment property is used to align the child elements at the start, center, or end of layout.
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp)
        )
        // Signature message Text Composable
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    end = 16.dp
                )
                .align(alignment = Alignment.CenterHorizontally)

        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    // Creating a box to overlap image and text
    Box(modifier) {
        Image(
            painter = painterResource(id = R.drawable.androidparty),
            //contentDescription argument set to null so that TalkBack skips the Image composable.
            contentDescription = null,
            // ContentScale.Crop parameter scaling, which scales the image uniformly to maintain the aspect ratio
            contentScale = ContentScale.Crop,
            // To improve the app's contrast
            alpha = 0.5F

        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
            )
    }
}


@Preview(
    showBackground = true,
    //showSystemUi = true,
    name = "My Preview"
)
@Composable
fun GreetingPreview() {
    Birthday_wishing_appTheme {
        GreetingImage(
            stringResource(id = R.string.happy_birthday_text),
            stringResource(id = R.string.signature_text)
        )
    }
}
