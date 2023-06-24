package com.jhonjto.prettytoastcompose

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jhonjto.prettytoast.FailedToast
import com.jhonjto.prettytoast.InfoToast
import com.jhonjto.prettytoast.SuccessToast
import com.jhonjto.prettytoastcompose.ui.theme.PrettyToastComposeTheme
import com.jhonjto.prettytoastjetpack.ArrangementPosition
import com.jhonjto.prettytoastjetpack.CustomSnackbar

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
                    FailedToast.failedToast(LocalContext.current as Activity, "Failed Toast Basic", Toast.LENGTH_SHORT)
                    FailedToast.failedToast(LocalContext.current as Activity, "Failed Toast with Font", Toast.LENGTH_SHORT, Typeface.SERIF)
                    FailedToast.failedToast(LocalContext.current as Activity, "Failed Toast with Font and Icon", Toast.LENGTH_SHORT, Typeface.MONOSPACE, com.jhonjto.prettytoast.R.drawable.failed_bg)

                    InfoToast.infoToast(LocalContext.current as Activity, "Info Toast Basic", Toast.LENGTH_SHORT)
                    InfoToast.infoToast(LocalContext.current as Activity, "Info Toast with Font", Toast.LENGTH_SHORT, Typeface.SERIF)
                    InfoToast.infoToast(LocalContext.current as Activity, "Info Toast with Font and Icon", Toast.LENGTH_SHORT, Typeface.MONOSPACE, com.jhonjto.prettytoast.R.drawable.info_bg)

                    SuccessToast.successToast(LocalContext.current as Activity, "Success Toast Basic", Toast.LENGTH_SHORT)
                    SuccessToast.successToast(LocalContext.current as Activity, "Success Toast with Font", Toast.LENGTH_SHORT, Typeface.SERIF)
                    SuccessToast.successToast(LocalContext.current as Activity, "Success Toast with Font and Icon", Toast.LENGTH_SHORT, Typeface.MONOSPACE, com.jhonjto.prettytoast.R.drawable.success_bg)

                    var snackbarVisible by remember { mutableStateOf(false) }

                    Column {
                        Button(onClick = { snackbarVisible = true }) {
                            Text(text = "Show Snackbar")
                        }

                        if (snackbarVisible) {
                            CustomSnackbar(
                                message = "This is a custom snackbar",
                                actionText = "Dismiss",
                                onActionClick = { snackbarVisible = false },
                                modifier = Modifier.padding(16.dp)
                            )
                           CustomSnackbar(
                                message = "This is a custom snackbar with custom color",
                                paddingAll = 12.dp,
                                verticalPadding = 6.dp,
                                horizontalPadding = 6.dp,
                                actionText = "Dissmiss",
                                onActionClick = { snackbarVisible = false },
                                onClickColor = Color.Magenta,
                                onMessageColor = Color.Red
                            )
                            CustomSnackbar(
                                message = "This is a custom snackbar with custom color and icon",
                                paddingAll = 12.dp,
                                arrangement = ArrangementPosition.Center,
                                verticalPadding = 12.dp,
                                horizontalPadding = 12.dp,
                                icon = Icons.Default.Info,
                                contentColor = Color.Gray,
                                actionText = "Dissmiss",
                                onActionClick = { snackbarVisible = false },
                                onClickColor = Color.Blue,
                                onMessageColor = Color.Red
                            )
                        }
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PrettyToastComposeTheme {
        }
    }
}