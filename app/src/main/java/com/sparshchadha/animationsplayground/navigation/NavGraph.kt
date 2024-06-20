package com.sparshchadha.animationsplayground.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.sparshchadha.animationsplayground.fragments.AnimationsTestingFragment
import com.sparshchadha.animationsplayground.fragments.HomeFragment
import com.sparshchadha.animationsplayground.fragments.PlantDetailsFragment
import com.sparshchadha.animationsplayground.fragments.PlantImageFragment

object NavGraph {
    fun getNavGraph(
        navController: NavController,
        startDestinationRoute: String
    ): NavGraph {
        return navController.createGraph(
            startDestination = startDestinationRoute
        ) {
            fragment<HomeFragment>(nav_routes.home) {
                label = "Home"
            }

            fragment<PlantDetailsFragment>(nav_routes.plant_detail) {
                label = "Plant details"
            }

            fragment<AnimationsTestingFragment>(nav_routes.animations_testing) {
                label = "Test Animations Here"
            }

            fragment<PlantImageFragment>(nav_routes.plant_image_fragment) {
                label = "Blue Orchids Image"
            }
        }
    }
}