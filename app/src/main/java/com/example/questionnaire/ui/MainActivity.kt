package com.example.questionnaire.ui

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.questionnaire.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var navigationView: BottomNavigationView
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.findNavController()
        navigationView = findViewById(R.id.navView)
        navigationView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, navDestination, _ ->
            navigationView.visibility = when (navDestination.id) {
                R.id.questions, R.id.results  -> View.VISIBLE
                else -> { View.VISIBLE }
            }
        }
    }
}
