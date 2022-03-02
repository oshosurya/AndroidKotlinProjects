package com.example.bottommenunavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.activity_main_bottom_navigation_view)
        bottomNavigationView.menu.setGroupCheckable(0,false,true)

        bottomNavigationView.setOnItemSelectedListener{
            firstItemSelection(bottomNavigationView, it)
            return@setOnItemSelectedListener true
        }
    }

     fun firstItemSelection(bottomNavigationView : BottomNavigationView, item: MenuItem){
        bottomNavigationView.menu.setGroupCheckable(0,true,true)
        val navController = findNavController(R.id.activity_main_nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)
        when(item.itemId){
            R.id.airdropsFragment -> bottomNavigationView.selectedItemId = R.id.airdropsFragment
            R.id.moreFragment -> bottomNavigationView.selectedItemId = R.id.moreFragment
            R.id.portfolioFragment -> bottomNavigationView.selectedItemId = R.id.portfolioFragment
            R.id.profileFragment -> bottomNavigationView.selectedItemId = R.id.profileFragment
            R.id.rankingsFragment -> bottomNavigationView.selectedItemId = R.id.rankingsFragment
        }
    }
}