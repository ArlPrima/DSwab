package com.example.dswap

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [RegistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var logoRegist : Button = view.findViewById(R.id.logoRegist)
        var btnnextregis : Button = view.findViewById(R.id.btnNext)
        var emailRegist  : EditText = view.findViewById(R.id.email)
        logoRegist.setOnClickListener{
            val ngintenRegist = Intent(getActivity(),home::class.java)
            startActivity(ngintenRegist)
        }
        btnnextregis.setOnClickListener{
            if(!emailRegist.text.toString().contains("@")) {
                Toast.makeText(getActivity(), "Email must be valid", Toast.LENGTH_SHORT).show()
                emailRegist.error="input valid Email using @"
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_regist, container, false)
    }
}