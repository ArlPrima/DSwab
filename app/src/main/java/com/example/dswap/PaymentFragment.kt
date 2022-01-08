package com.example.dswap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.firebase.database.FirebaseDatabase


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
    lateinit var  icon_notif :ImageView
    lateinit var textpaycheck:TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         icon_notif = view.findViewById(R.id.notif_icon_check)
        val btncheck = view.findViewById<Button>(R.id.btncekpay)
         textpaycheck = view.findViewById(R.id.paymentnotif)
        val inputcek = view.findViewById<EditText>(R.id.cek_email)
        btncheck.setOnClickListener {
            val cek = inputcek.text.toString().replace(".",",")
            if (cek == null || cek.trim() == "") {
                Toast.makeText(
                    getActivity(),
                    "Insert the email to check your payment",
                    Toast.LENGTH_SHORT
                ).show()
                inputcek.error = "input your correct email"
            }
            else{
                readData(cek)
            }

        }
    }

    private fun readData(cek: String) {
        var databases = FirebaseDatabase.getInstance("https://dswap-a3b71-default-rtdb.asia-southeast1.firebasedatabase.app/")
            .getReference("user")
        databases.child(cek).get().addOnSuccessListener {
            if (cek == it.child("email").value){
                textpaycheck.setText("Your payment have been approved")
                icon_notif.setImageResource(R.drawable.correct_check_email)

            }else{

                textpaycheck.setText("Email not registered.")
                icon_notif.setImageResource(R.drawable.warning_check)
            }
        }

    }

}