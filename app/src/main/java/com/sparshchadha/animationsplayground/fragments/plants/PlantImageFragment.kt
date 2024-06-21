package com.sparshchadha.animationsplayground.fragments.plants

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.sparshchadha.animationsplayground.R
import com.sparshchadha.animationsplayground.common_composables.AnimationsPlaygroundTopBar
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

private const val TAG = "PlantImageFragment"
class PlantImageFragment : Fragment(R.layout.plant_image_fragment) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.shared_image)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rootComposeView = view.findViewById<ComposeView>(R.id.plant_details_root_view)
        rootComposeView.setContent {
            var offsetX by remember {
                mutableFloatStateOf(0f)
            }
            var offsetY by remember {
                mutableFloatStateOf(0f)
            }
            var iconOffset by remember {
                mutableFloatStateOf(0f)
            }

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
                            setImageResource(R.drawable.flower_image)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
//                        .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
//                        .pointerInput(Unit) {
//                            detectDragGestures { change, dragAmount ->
//                                change.consume()
//                                offsetX = (offsetX + dragAmount.x)
//                                offsetY = (offsetY + dragAmount.y)
//                                    .coerceIn(0f, size.height.toFloat() / 2)
//                            }
//                        }
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = null,
                        modifier = Modifier
                            .offset {
                                (IntOffset(iconOffset.roundToInt(), 0))
                            }
                            .size(50.dp)
                            .draggable(
                                state = rememberDraggableState {
                                    if (iconOffset < 500) {
                                        iconOffset += it
                                    } else if (iconOffset >= 500 && it < 0) {
                                        iconOffset += it
                                    }
                                    Log.e(TAG, "onViewCreated: Calculating offset - $it")
                                },
                                orientation = Orientation.Horizontal
                            )

                    )
                }
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