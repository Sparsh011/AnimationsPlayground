package com.sparshchadha.animationsplayground.fragments.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
internal fun HomeScreenBottomBar(
    modifier: Modifier,
    onIconIndexChange: (Int) -> Unit,
    selectedIconIndex: Int
) {
    Row(
        modifier = modifier
    ) {
        BottomBarIcon(
            modifier = Modifier
                .weight(1f),
            text = "Plant Handler",
            icon = Icons.Outlined.Home,
            isSelected = selectedIconIndex == 0,
            onClick = {
                if (selectedIconIndex != 0) {
                    onIconIndexChange(0)
                }
            },
        )

        BottomBarIcon(
            modifier = Modifier
                .weight(1f),
            text = "Away",
            icon = Icons.Outlined.Call,
            isSelected = selectedIconIndex == 1,
            onClick = {
                if (selectedIconIndex != 1) {
                    onIconIndexChange(1)
                }
            }
        )

        BottomBarIcon(
            modifier = Modifier
                .weight(1f),
            text = "Animations",
            icon = Icons.Outlined.Call,
            isSelected = selectedIconIndex == 2,
            onClick = {
                if (selectedIconIndex != 2) {
                    onIconIndexChange(2)
                }
            }
        )
    }
}

@Composable
private fun BottomBarIcon(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit,
) {

    var showSelectionAnim by remember {
        mutableStateOf(false)
    }
    val alpha by animateDpAsState(
        targetValue = if (showSelectionAnim) -(5).dp else 0.dp,
        animationSpec = spring(), label = ""
    )

    Column(
        modifier = modifier
            .clickable {
                if (!isSelected) showSelectionAnim = true
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isSelected) {
            LaunchedEffect(key1 = Unit) {
                delay(300)
                showSelectionAnim = false

            }
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Red,
                modifier = Modifier.offset(y = alpha)
            )
        } else {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.LightGray,
            )
        }


        Text(
            text = text,
            color = if (isSelected) Color.Black else Color.LightGray,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            fontSize = 13.sp
        )
    }
}