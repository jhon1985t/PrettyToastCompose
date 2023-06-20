package com.jhonjto.prettytoastcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jhonjto.prettytoastcompose.ui.theme.PrettyToastComposeTheme
import com.jhonjto.prettytoastjetpack.ArrangementPosition
import com.jhonjto.prettytoastjetpack.FailedSnackbar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrettyToastComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                    FailedSnackbar(
                        message = "test",
                        paddingAll = 12.dp,
                        arrangement = ArrangementPosition.Bottom,
                        containerColor = Color.Blue,
                        verticalPadding = 12.dp,
                        horizontalPadding = 12.dp,
                        icon = Icons.Default.Search,
                        contentColor = Color.Blue
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PrettyToastComposeTheme {
        Greeting("Android")
    }
}