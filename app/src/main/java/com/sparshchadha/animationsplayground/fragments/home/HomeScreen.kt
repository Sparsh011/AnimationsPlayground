package com.sparshchadha.animationsplayground.fragments.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sparshchadha.animationsplayground.navigation.NavigationProvider

@Composable
fun HomeScreen(
    navController: NavController
) {
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
                NavigationProvider.navigateToPlantDetailsScreen(navController = navController)
            },
            modifier = Modifier.weight(.95f)
        )

        HomeScreenBottomBar(
            modifier = Modifier,
            onIconIndexChange = {
                selectedIconIndex = it
            },
            selectedIconIndex = selectedIconIndex
        )
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