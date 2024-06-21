package com.sparshchadha.animationsplayground.activities.extensions

import android.view.WindowManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.sparshchadha.animationsplayground.R
import com.sparshchadha.animationsplayground.activities.MainActivity
import com.sparshchadha.animationsplayground.navigation.NavGraph
import com.sparshchadha.animationsplayground.navigation.nav_routes

internal fun MainActivity.setNavGraph() {
    val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    val navController = navHostFragment.navController
    navController.graph = NavGraph.getNavGraph(
        navController = navController,
        startDestinationRoute = nav_routes.home
    )
}

internal fun MainActivity.setWindowAttributes() {
    window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window?.statusBarColor = Color.White.toArgb()

    WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars = true

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
    }
}