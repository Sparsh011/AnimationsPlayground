package com.sparshchadha.animationsplayground.fragments.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.unit.sp

@Composable
internal fun HomeScreenBottomBar(
    modifier: Modifier,
    onIconIndexChange: (Int) -> Unit,
    selectedIconIndex: Int,
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

    AnimatedContent(
        targetState = isSelected,
        label = "",
        transitionSpec = {
            if (isSelected) {
                (fadeIn(animationSpec = spring()) +
                        scaleIn(initialScale = 0.92f, animationSpec = spring()))
                    .togetherWith(fadeOut(animationSpec = tween(90)))
            } else {
                (EnterTransition.None
                    .togetherWith(ExitTransition.None))
            }
        },
        modifier = modifier
            .clickable {
                if (!isSelected) showSelectionAnim = true
                onClick()
            },
    ) { targetSelected ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LaunchedEffect(Unit) {
                if (isSelected) {
                    showSelectionAnim = false
                }
            }

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (targetSelected) Color.Red else Color.LightGray,
            )

            Text(
                text = text,
                color = if (targetSelected) Color.Black else Color.LightGray,
                fontWeight = if (targetSelected) FontWeight.Bold else FontWeight.Normal,
                fontSize = 16.sp
            )
        }
    }
}