package com.sparshchadha.animationsplayground.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.sparshchadha.animationsplayground.R

class PlantImageFragment: Fragment(R.layout.plant_image_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
        val blueOrchidImage = view.findViewById<ImageView>(R.id.blue_orchid_image)
        blueOrchidImage.setImageResource(R.drawable.flower_image)
    }
}