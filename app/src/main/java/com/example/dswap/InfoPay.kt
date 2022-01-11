package com.example.dswap

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class InfoPay : AppCompatActivity() {
    private lateinit var btnConfirm : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_pay)
        val PopUpDialog = AlertDialog.Builder(this)
        btnConfirm = findViewById(R.id.btnConfirm)

        btnConfirm.setOnClickListener {

            val view = View.inflate(this,R.layout.pay_popup,null)
            val builder = PopUpDialog.setView(view)
            val dialog = builder.create()
            dialog.show()
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            val confrimbtn = view.findViewById<Button>(R.id.btnOK)

            confrimbtn.setOnClickListener{
                dialog.dismiss()
                val BacktoHome = Intent(this,home::class.java)
                startActivity(BacktoHome)
            }
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