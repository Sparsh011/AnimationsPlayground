package com.sparshchadha.animationsplayground.fragments.animations_test

import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.sparshchadha.animationsplayground.R

class AnimationsTestingFragment: Fragment(R.layout.animations_testing_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rootComposeView = view.findViewById<ComposeView>(R.id.animations_fragment_compose_view)
        rootComposeView.setContent {

        }
    }
}