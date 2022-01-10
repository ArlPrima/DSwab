package com.example.dswap

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView

class InfoPay : AppCompatActivity() {
    private lateinit var btnPayNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_pay)

        btnPayNext = findViewById(R.id.btnPayNext)
        btnPayNext.setOnClickListener {

        }
    }

    private fun customDialog () {
        val dialog = Dialog( this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.custom_dialog)

        val txtAccount = dialog.findViewById<TextView>(R.id.txtAccount)
        txtAccount.setOnClickListener{
            dialog.dismiss()
        }
        dialog.show()
    }
}