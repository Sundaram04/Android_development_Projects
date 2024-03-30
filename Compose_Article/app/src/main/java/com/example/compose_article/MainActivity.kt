package com.example.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose_article.ui.theme.Compose_ArticleTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_ArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleImage(
                        stringResource(R.string.Heading),
                        stringResource(R.string.Paragraph_1),
                        stringResource(R.string.Paragraph_2)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleText(title: String, para_1: String, para_2: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                    top = 16.dp
                )
        )

        Text(
            text = para_1,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                ),
            textAlign = TextAlign.Justify
        )

        Text(
            text = para_2,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp,
                    top = 16.dp
                ),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ArticleImage(title: String, para_1: String, para_2: String, modifier: Modifier = Modifier) {
    Column {

            Image(
                painter = painterResource(id = R.drawable.bg_compose_background),
                contentDescription = null,
                modifier.padding()
            )

            ArticleText(
                title = title,
                para_1 = para_1,
                para_2 = para_2)
    }
}

@Preview(showBackground = true)
@Composable
fun Compose_ArticleAppPreview() {
    Compose_ArticleTheme {
        ArticleImage(
            stringResource(id = R.string.Heading),
            stringResource(id = R.string.Paragraph_1),
            stringResource(id = R.string.Paragraph_2)
        )
    }
}