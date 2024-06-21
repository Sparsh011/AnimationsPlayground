package com.sparshchadha.animationsplayground.fragments.plants

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sparshchadha.animationsplayground.R
import com.sparshchadha.animationsplayground.common_composables.AnimationsPlaygroundTopBar
import com.sparshchadha.animationsplayground.navigation.NavigationProvider
import com.sparshchadha.animationsplayground.utils.Dimensions

class PlantDetailsFragment : Fragment(R.layout.plant_details_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rootComposeView = view.findViewById<ComposeView>(R.id.plant_details_compose_view)

        rootComposeView.setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = Dimensions.statusBarTopPadding.dp)
            ) {
                AnimationsPlaygroundTopBar(
                    topBarTitle = "Plant details",
                    onBackPressed = {
                        popBackStackWithoutDestination()
                    }
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "This is Blue Orchid",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )

                    AndroidView(
                        factory = {
                            ImageView(it).apply {
                                this.setImageResource(R.drawable.flower_image)
                                this.transitionName = "plant_image"
                                this.setOnClickListener {
                                    ViewCompat.setTransitionName(this, "plant_image")
                                    NavigationProvider.navigateToPlantImageScreen(
                                        navController = findNavController(),
                                        transitionName = "plant_image",
                                        view = this
                                    )
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )

                    Text(
                        text = stringResource(id = R.string.blue_orchids_summary),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    )
                }
            }
        }
    }

    private fun popBackStackWithoutDestination() {
        findNavController().popBackStack()
    }

    override fun onResume() {
        super.onResume()
        val window: Window? = activity?.window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = Color(red = 240, green = 254, blue = 255).toArgb()
    }

    override fun onStop() {
        super.onStop()
        val window: Window? = activity?.window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = Color.White.toArgb()
    }
}