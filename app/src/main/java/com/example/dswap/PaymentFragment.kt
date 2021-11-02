package com.example.dswap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*



/**
 * A simple [Fragment] subclass.
 * Use the [PaymentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PaymentFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val icon_notif   = view.findViewById<ImageView>(R.id.notif_icon_check)
        val btncheck     = view.findViewById<Button>(R.id.btncekpay)
        val textpaycheck = view.findViewById<TextView>(R.id.paymentnotif)
        val inputcek     = view.findViewById<EditText>(R.id.cek_email)
        btncheck.setOnClickListener{
            val cek= inputcek.text.toString()
            if(cek==null||cek.trim()==""){
                Toast.makeText(getActivity(), "Insert the email to check your payment", Toast.LENGTH_SHORT).show()
                inputcek.error="input your correct email"
            }
            else if(cek=="overdose@gmail.com"){
                textpaycheck.setText("Your payment have been approved")
                icon_notif.setImageResource(R.drawable.correct_check_email)
            }
            else {
                textpaycheck.setText("Email not registered.")
                icon_notif.setImageResource(R.drawable.warning_check)

            }
        }
    }

}