package com.sparshchadha.animationsplayground.navigation

import android.view.View
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigatorExtras
import com.sparshchadha.animationsplayground.R


object NavigationProvider {
    fun navigateToPlantDetailsScreen(
        navController: NavController
    ) {
        val navBuilder = NavOptions.Builder()
        navBuilder.setEnterAnim(R.anim.slide_in).setExitAnim(R.anim.fade_out)
            .setPopEnterAnim(R.anim.fade_in).setPopExitAnim(R.anim.slide_out)
        navController.navigate(
            route = nav_routes.plant_detail,
            navOptions = navBuilder.build()
        )
    }

    fun navigateToPlantImageScreen(
        navController: NavController,
        transitionName: String,
        view: ImageView
    ) {
        // This animation is shared element transition
        val extras = FragmentNavigatorExtras(view to transitionName)
        navController.navigate(
           nav_routes.plant_image_fragment,
            null,
            extras
        )
    }
}