package com.sparshchadha.animationsplayground.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.sparshchadha.animationsplayground.R
import com.sparshchadha.animationsplayground.activities.extensions.setNavGraph
import com.sparshchadha.animationsplayground.activities.extensions.setWindowAttributes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setWindowAttributes()
        setNavGraph()
    }
}