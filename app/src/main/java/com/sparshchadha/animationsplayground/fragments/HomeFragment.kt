package com.sparshchadha.animationsplayground.fragments

import android.os.Bundle
import android.view.View
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sparshchadha.animationsplayground.R
import com.sparshchadha.animationsplayground.navigation.NavigationProvider
import kotlinx.coroutines.delay


private const val TAG = "HomeFragment"

class HomeFragment : Fragment(R.layout.home_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rootComposeView = view.findViewById<ComposeView>(R.id.home_compose_view)

        rootComposeView.setContent {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                var selectedIconIndex by rememberSaveable {
                    mutableIntStateOf(0)
                }

                ColumnContent(
                    onNavigate = {
                        NavigationProvider.navigateToPlantDetailsScreen(navController = findNavController())
                    },
                    modifier = Modifier.weight(.95f)
                )

                HomeFragmentBottomBar(
                    modifier = Modifier,
                    onIconIndexChange = {
                        selectedIconIndex = it
                    },
                    selectedIconIndex = selectedIconIndex
                )
            }
        }
    }
}

@Composable
private fun ColumnContent(
    onNavigate: () -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier
    ) {
        Button(
            onClick = {
                onNavigate()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(text = "Go to plant details screen")
        }
    }
}

@Composable
private fun HomeFragmentBottomBar(
    modifier: Modifier,
    onIconIndexChange: (Int) -> Unit,
    selectedIconIndex: Int
) {
    Row(
        modifier = modifier
    ) {
        BottomBarIcon(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    if (selectedIconIndex != 0) {
                        onIconIndexChange(0)
                    }
                },
            text = "Home",
            icon = Icons.Default.Home,
            isSelected = selectedIconIndex == 0
        )

        BottomBarIcon(
            modifier = Modifier
                .weight(1f)
                .clickable {
                    if (selectedIconIndex != 1) {
                        onIconIndexChange(1)
                    }
                },
            text = "Away",
            icon = Icons.Default.Call,
            isSelected = selectedIconIndex == 1
        )
    }
}

@Composable
fun BottomBarIcon(
    modifier: Modifier = Modifier,
    text: String,
    icon: ImageVector,
    isSelected: Boolean
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (isSelected) Color.Red else Color.LightGray,
        )

        Text(
            text = text,
            color = if (isSelected) Color.Black else Color.LightGray,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            fontSize = 16.sp
        )
    }
}