package com.example.affirmations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.affirmations.model.Affirmations
import com.example.affirmations.ui.theme.AffirmationsTheme
import androidx.compose.material3.Card
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.affirmations.Data.Datasource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}

@Composable
fun AffirmationsApp() {
    AffirmationsList(affirmationsList = Datasource().loadAffirmations())
}

@Composable
// The Affirmation object comes from the model package.
fun AffirmationCard(affirmations: Affirmations, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(painter = painterResource(id = affirmations.imageResourceId),
                contentDescription = stringResource(id = affirmations.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop    //contentScale determines how the image should be scaled and displayed
            )
            Text(
                text = LocalContext.current.getString(affirmations.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }

}

@Composable
//declaring a List of Affirmation objects as a parameter in the method signature.
fun AffirmationsList(affirmationsList: List<Affirmations>, modifier: Modifier = Modifier) {
//    a scrollable list can be made using the LazyColumn composable
    LazyColumn(modifier = modifier) {
        // The items() method is how you add items to the LazyColumn
        items(affirmationsList) { affirmation ->
            // A call to the items() method requires a lambda function. In that function,
            // specify a parameter of affirmation that represents one affirmation item from the affirmationList.
            AffirmationCard(affirmations = affirmation, modifier = Modifier.padding(8.dp))

        }

    }
}

@Preview
@Composable
private fun AffirmationsCardPreview() {
    AffirmationsList(affirmationsList = Datasource().loadAffirmations())
}