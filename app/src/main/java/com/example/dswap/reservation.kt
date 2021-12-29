package com.example.dswap

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class reservation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)
        val registration = RegistFragment()
        val detail = DetailFragment()
        val pay = PayFragment()
        val navbtnRegist = findViewById(R.id.bottomNavigationViewRegist) as BottomNavigationView
         CurrentFragmentSet(registration)
        navbtnRegist.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.registration -> CurrentFragmentSet(registration)
                R.id.detail -> CurrentFragmentSet(detail)
                R.id.pay -> CurrentFragmentSet(pay)

            }

            true
        }
    }

    private fun CurrentFragmentSet(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment2, fragment)
//                .addToBackStack(null)
            commit()
        }
    }
}
