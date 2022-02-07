package com.example.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
// import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testing.fragments.InfoFragment
import com.example.testing.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // Create variable that stores the fragments
    private val infoFragment = InfoFragment()
    private val settingsFragment = SettingsFragment()

    // Used to modify the nav bar
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(infoFragment)

        // Switch to different fragments when the nav bar is clicked
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_info -> replaceFragment(infoFragment)
                R.id.ic_settings -> replaceFragment(settingsFragment)
            }
            true
        }
    }

    // A function that provides switches between the fragments
    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }
}