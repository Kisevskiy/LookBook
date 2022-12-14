package com.noto.userbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController(findNavController(R.id.nav_fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val controller = findNavController(R.id.nav_fragment)
        return controller.navigateUp()|| super.onSupportNavigateUp()
    }
}