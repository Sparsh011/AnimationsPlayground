package com.sparshchadha.animationsplayground.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sparshchadha.animationsplayground.R
import com.sparshchadha.animationsplayground.navigation.nav_routes

private const val TAG = "HomeFragment"
class HomeFragment : Fragment(R.layout.home_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rootComposeView = view.findViewById<ComposeView>(R.id.home_compose_view)
        Log.e(TAG, "onViewCreated: called")

        rootComposeView.setContent {
            var plantId by remember {
                mutableIntStateOf(0)
            }
            Button(
                onClick = {
                    navigateToPlant(plantId = plantId.toString(), navController = findNavController())
                    plantId++
                }
            ) {
                Text(text = "Go to plant details screen and increment id by 1")
            }
        }
    }

    private fun navigateToPlant(
        plantId: String,
        navController: NavController
    ) {
        navController.navigate("${nav_routes.plant_detail}/$plantId")
    }
}