package com.sparshchadha.animationsplayground.compose_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnimationsPlaygroundTopBar(
    icon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    topBarTitle: String,
    onBackPressed: () -> Unit = {},
    showBackButton: Boolean = true,
) {
    Row (
        modifier = Modifier
            .background(Color(red = 240, green = 254, blue = 255))
            .padding(vertical = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showBackButton) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        onBackPressed()
                    }
                    .weight(1f),
            )
        }

        Text(
            text = topBarTitle,
            textAlign = TextAlign.Start,
            fontSize = 20.sp,
            modifier = Modifier
                .weight(4f)
        )
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    AnimationsPlaygroundTopBar(
        icon = Icons.AutoMirrored.Filled.ArrowBack,
        topBarTitle = "Preview Title",
    )
}