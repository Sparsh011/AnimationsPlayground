package com.sparshchadha.animationsplayground

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.Navigation.findNavController
import androidx.navigation.createGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.fragment
import com.sparshchadha.animationsplayground.fragments.AnimationsTestingFragment
import com.sparshchadha.animationsplayground.fragments.HomeFragment
import com.sparshchadha.animationsplayground.fragments.PlantDetailsFragment
import com.sparshchadha.animationsplayground.navigation.NavGraph
import com.sparshchadha.animationsplayground.navigation.nav_arguments
import com.sparshchadha.animationsplayground.navigation.nav_routes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.graph = navController.createGraph(
            startDestination = nav_routes.home
        ) {
            fragment<HomeFragment>(nav_routes.home) {
                label = "Home"
            }

            fragment<PlantDetailsFragment>("${nav_routes.plant_detail}/{${nav_arguments.plant_id}}") {
                label = "Plant details"
                argument(nav_arguments.plant_id) {
                    type = NavType.StringType
                }
            }

            fragment<AnimationsTestingFragment>(nav_routes.animations_testing) {
                label = "Test Animations Here"
            }
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)

    }
}