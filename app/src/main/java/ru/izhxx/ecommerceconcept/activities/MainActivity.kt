package ru.izhxx.ecommerceconcept.activities

import android.opengl.Visibility
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

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    fun changeCartProducts(productsCount: Int) {
        val badge = binding.bottomMenu.getOrCreateBadge(R.id.cart_fragment)
        if (productsCount == 0) {
            badge.isVisible = false
            badge.clearNumber()
        } else {
            badge.isVisible = true
            badge.number = productsCount
        }
    }

    fun changeBottomMenuVisibility(visibility: Int) {
        binding.bottomMenu.visibility = visibility
    }
}