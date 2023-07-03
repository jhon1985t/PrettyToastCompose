package com.jhonjto.prettytoast

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CustomSnackbar(
    modifier: Modifier = Modifier,
    message: String,
    actionText: String,
    onActionClick: () -> Unit
) {
    Snackbar(
        modifier = modifier,
        action = {
            TextButton(onClick = onActionClick) {
                Text(
                    text = actionText,
                    color = Color.White
                )
            }
        }
    ) {
        Column(
            modifier = modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = message,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun CustomSnackbar(
    modifier: Modifier = Modifier,
    message: String,
    paddingAll: Dp,
    verticalPadding: Dp,
    horizontalPadding: Dp,
    actionText: String,
    onActionClick: () -> Unit,
    onClickColor: Color,
    onMessageColor: Color
) {
    Snackbar(
        modifier = modifier,
        action = {
            TextButton(onClick = onActionClick) {
                Text(
                    text = actionText,
                    color = onClickColor
                )
            }
        }
    ) {
        Column(
            modifier = modifier
                .padding(paddingAll),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = modifier
                    .padding(vertical = verticalPadding)
                    .padding(horizontal = horizontalPadding),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = modifier.weight(4f), verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = modifier.width(12.dp))

                    Text(
                        text = message ?: "Unknown",
                        color = onMessageColor,
                        style = MaterialTheme.typography.bodyMedium,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

@Composable
fun CustomSnackbar(
    modifier: Modifier = Modifier,
    message: String,
    paddingAll: Dp,
    arrangement: ArrangementPosition,
    verticalPadding: Dp,
    horizontalPadding: Dp,
    icon: ImageVector,
    contentColor: Color,
    actionText: String,
    onActionClick: () -> Unit,
    onClickColor: Color,
    onMessageColor: Color
) {
    Snackbar(
        modifier = modifier,
        action = {
            TextButton(onClick = onActionClick) {
                Text(
                    text = actionText,
                    color = onClickColor
                )
            }
        }
    ) {
        Column(
            modifier = modifier
                .padding(paddingAll),
            verticalArrangement = when (arrangement) {
                is ArrangementPosition.Bottom -> Arrangement.Bottom
                is ArrangementPosition.Center -> Arrangement.Center
                is ArrangementPosition.Top -> Arrangement.Top
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = modifier
                    .padding(vertical = verticalPadding)
                    .padding(horizontal = horizontalPadding)
                    .animateContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = modifier.weight(4f), verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Default Image",
                        tint = contentColor
                    )

                    Spacer(modifier = modifier.width(12.dp))

                    Text(
                        text = message ?: "Unknown",
                        color = onMessageColor,
                        style = MaterialTheme.typography.bodyMedium,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }
        }
    }
}

sealed class ArrangementPosition {
    object Bottom : ArrangementPosition()
    object Center : ArrangementPosition()
    object Top : ArrangementPosition()
}
