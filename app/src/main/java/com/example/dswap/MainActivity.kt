package com.example.dswap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT//IMPORT BABII
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2


class MainActivity : AppCompatActivity() {
    private val introSliderAdapter = introSliderAdapter(
        listOf(
            introSlide(
                "Wear a Mask",
            "Lorem ipsum dolor sit amet,  lacus, maecenas odio ac.",
                R.drawable.undraw_social_distancing_2g0u_1
            ),introSlide(
                "Hand Wash & Sanitize",
                "Lorem ipsum dolor sit amet,  lacus, maecenas odio ac.",
                R.drawable.undraw_wash_hands_nwl2_1
            ),introSlide(
                "Pyshical Distancing",
                "Lorem ipsum dolor sit amet, ",
                R.drawable.undraw_medical_care_movn_1
            )
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        var narurto=findViewById<ViewPager2>(R.id.introSliderViewPager)//masukin variabel viewpager
         narurto.adapter = introSliderAdapter
        setupindicator()
        setcurrentIndicator(0)
        narurto.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setcurrentIndicator(position)
            }
        })
        var buttonNext:Button = findViewById(R.id.buttonNext)
        buttonNext.setOnClickListener{
            if(narurto.currentItem+1<introSliderAdapter.itemCount){
                narurto.currentItem +=1
            }else{
                Intent(applicationContext,home::class.java).also{
                    startActivity(it)
                    finish()
                }
            }
        }
    }
    private fun setupindicator(){
        val indicator= arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams:LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT,WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for (i in indicator.indices){
            indicator[i] = ImageView(applicationContext)
            indicator[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            var container = findViewById<LinearLayout>(R.id.indicatorsContainer)
            container.addView(indicator[i])
        }
    }
    private fun setcurrentIndicator(index:Int){
        var container = findViewById<LinearLayout>(R.id.indicatorsContainer)
        var buttonNext:Button= findViewById(R.id.buttonNext)
        val childCount = container.childCount
        for (i in 0 until childCount){
            val imageView = container[i] as ImageView
            if (i==index){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,R.drawable.indicator_active)
                )
            }
            else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext,R.drawable.indicator_inactive)
                )
            }
        }
        if(index == introSliderAdapter.itemCount-1){
            buttonNext.setText("Getstarted")
        }else{
            buttonNext.setText("Next")
        }
    }
}