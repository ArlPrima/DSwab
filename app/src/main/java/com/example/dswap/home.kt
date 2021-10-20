package com.example.dswap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val home     = homeFragment()
        val symtomps = SymptomsFragment()
        val payment  = PaymentFragment()
        val help     = HelpFragment()
        val navbtn   = findViewById(R.id.bottomNavigationView) as BottomNavigationView
        CurrentFragmentSet(home)
        navbtn.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> CurrentFragmentSet(home)
                R.id.payment -> CurrentFragmentSet(payment)
                R.id.symptoms -> CurrentFragmentSet(symtomps)
                R.id.help -> CurrentFragmentSet(help)
            }
            true
        }


    }

    private fun CurrentFragmentSet(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()

        }
    }
}


