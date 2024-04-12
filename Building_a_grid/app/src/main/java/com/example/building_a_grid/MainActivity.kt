package com.example.building_a_grid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.building_a_grid.ui.theme.Building_a_gridTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import com.example.building_a_grid.data.DataSource
import com.example.building_a_grid.model.Topic
import androidx.compose.foundation.lazy.grid.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Building_a_gridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseGrid(modifier = Modifier.padding(start = 8.dp,top = 8.dp, end = 8.dp))
                }
            }
        }
    }
}

@Composable
fun GridUi(course: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier){
        Row(
            modifier = Modifier
        ) {
            Image(
                painter = painterResource(id = course.imageRes),
                contentDescription = stringResource(id = course.name),
                alignment = Alignment.CenterStart,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)
            )
            Column {
                Text(
                    text = stringResource(id = course.name),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            top = 16.dp,
                            end = 16.dp,
                            bottom = 8.dp
                        )
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "null",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Text(
                        text = course.availableCourses.toString(),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 8.dp)

                    )
                }
            }

        }
    }
}

@Composable
fun CourseGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(DataSource.topics) { topic ->
            GridUi(topic)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Building_a_gridTheme {
        val ref = Topic(R.string.photography, 321, R.drawable.photography)
        GridUi(course = ref )
    }
}