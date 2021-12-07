package com.dina.fragmentstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)

        val startFragment = StartFragment()
        val endFragment = EndFragment()


        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment:Fragment? = null
            when (item.itemId) {
                R.id.page_1 -> {
                    fragment = StartFragment()
                }
                R.id.page_2 -> {
                    fragment = EndFragment()
                }
            }
            replace_fragment(fragment!!)
            true
        }

        bottomNavigationMenu.selectedItemId = R.id.page_1

    }

    fun replace_fragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
}