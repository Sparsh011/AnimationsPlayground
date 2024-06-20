package com.sparshchadha.animationsplayground.fragments

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sparshchadha.animationsplayground.R
import com.sparshchadha.animationsplayground.navigation.NavigationProvider


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
                ColumnContent(
                    onNavigate = {
                        NavigationProvider.navigateToPlantDetailsScreen(navController = findNavController())
                    },
                )

                HomeFragmentBottomBar()
            }
        }
    }
}

@Composable
private fun ColumnContent(
    onNavigate: () -> Unit,
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

@Composable
private fun HomeFragmentBottomBar() {
    Row {
        BottomBarIcon()
        BottomBarIcon()
    }
}

@Composable
private fun BottomBarIcon() {

}