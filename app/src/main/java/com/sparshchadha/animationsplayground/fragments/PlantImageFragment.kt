package com.sparshchadha.animationsplayground.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.sparshchadha.animationsplayground.R
import com.sparshchadha.animationsplayground.compose_components.AnimationsPlaygroundTopBar
import java.util.concurrent.TimeUnit

class PlantImageFragment : Fragment(R.layout.plant_image_fragment) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rootComposeView = view.findViewById<ComposeView>(R.id.plant_details_root_view)
        rootComposeView.setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                AnimationsPlaygroundTopBar(
                    topBarTitle = "Blue Orchids Image Screen",
                    onBackPressed = {
                        findNavController().popBackStack()
                    },
                )

                AndroidView(
                    factory = {
                        ImageView(it).apply {
                            transitionName = "plant_image"
                            setImageResource(R.drawable.gogeta)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )

                Text(
                    text = "This is the end of ImageView",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val window: Window? = activity?.window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = Color(red = 240, green = 254, blue = 255).toArgb()
    }
}