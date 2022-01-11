package com.example.dswap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.kofigyan.stateprogressbar.StateProgressBar

class PayActivity : AppCompatActivity() {
    protected var descriptionData = arrayOf("Registration", "Detail", "Payment")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        var logoPay : Button = findViewById(R.id.logoPay)
        var pay :Button = findViewById(R.id.btnPayNext)

        var stateprogressbarPay = findViewById<View>(R.id.state_progress_bar_id) as StateProgressBar
        stateprogressbarPay.setStateDescriptionData(descriptionData)


        pay.setOnClickListener{
            var IntentPayCompletea =Intent(this,InfoPay::class.java)
            startActivity(IntentPayCompletea)
        }
        logoPay.setOnClickListener{
            var ngintenPay = Intent(this,home::class.java)
            startActivity(ngintenPay)
        }
    }
}