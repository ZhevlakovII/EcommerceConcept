package ru.izhxx.ecommerceconcept.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.izhxx.ecommerceconcept.R
import ru.izhxx.ecommerceconcept.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomMenu: BottomNavigationView = binding.bottomMenu

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        bottomMenu.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.cart_fragment -> bottomMenu.visibility = View.GONE
                R.id.details_fragment -> bottomMenu.visibility = View.GONE
                else -> bottomMenu.visibility = View.VISIBLE
            }
        }
    }
}