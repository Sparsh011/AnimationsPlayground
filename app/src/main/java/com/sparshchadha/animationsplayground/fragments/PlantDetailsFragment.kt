package com.sparshchadha.animationsplayground.fragments

import android.os.Bundle
import android.view.View
import androidx.compose.material3.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.sparshchadha.animationsplayground.R
import com.sparshchadha.animationsplayground.navigation.nav_arguments

class PlantDetailsFragment: Fragment(R.layout.plant_details_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val plantId: String? = arguments?.getString(nav_arguments.plant_id)
        val rootComposeView = view.findViewById<ComposeView>(R.id.plant_details_compose_view)
        rootComposeView.setContent {
            Text(text = plantId.toString())
        }
    }
}