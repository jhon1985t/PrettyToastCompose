package com.jhonjto.prettytoastjetpack

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FailedSnackbar(
    modifier: Modifier = Modifier,
    message: String,
    paddingAll: Dp,
    arrangement: ArrangementPosition,
    containerColor: Color,
    verticalPadding: Dp,
    horizontalPadding: Dp,
    icon: ImageVector,
    contentColor: Color
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingAll),
            verticalArrangement = when (arrangement) {
                is ArrangementPosition.Bottom -> Arrangement.Bottom
                is ArrangementPosition.Center -> Arrangement.Center
                is ArrangementPosition.Top -> Arrangement.Top
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(
                        fraction = when (arrangement) {
                            is ArrangementPosition.Bottom -> 1f
                            is ArrangementPosition.Center -> 1f
                            is ArrangementPosition.Top -> 0.8f
                        }
                    )
                    .background(
                        color = containerColor,
                        shape = when (arrangement) {
                            is ArrangementPosition.Bottom -> RectangleShape
                            is ArrangementPosition.Center -> RectangleShape
                            is ArrangementPosition.Top -> RoundedCornerShape(8.dp)
                        }
                    )
                    .padding(vertical = verticalPadding)
                    .padding(horizontal = horizontalPadding)
                    .animateContentSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = modifier.weight(4f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Default Image",
                        tint = contentColor
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = message ?: "Unknown",
                        color = contentColor,
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
