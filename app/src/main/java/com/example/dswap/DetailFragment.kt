package com.example.dswap

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var logoDetail : Button = view.findViewById(R.id.logoDetail)
        var textfield = view.findViewById<TextInputLayout>(R.id.klinik)
        var textfield2 = view.findViewById<TextInputLayout>(R.id.jenisTes)
        var datefield = view.findViewById<EditText>(R.id.tanggalTes)
//
//      val items = listOf("Material", "Design", "Components", "Android")// can set the list of drop down array in here
        val rs = resources.getStringArray(R.array.RumahSakit)//using list input of dropdown in the file string in arrray name RumahSakit
        val rsAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_template, rs)
        (textfield.editText as? AutoCompleteTextView)?.setAdapter(rsAdapter)

        val tes = resources.getStringArray(R.array.JenisTes)
        val tesAdapter= ArrayAdapter(requireContext(), R.layout.dropdown_template, tes)
        (textfield2.editText as? AutoCompleteTextView)?.setAdapter(tesAdapter)

        datefield.setOnClickListener(){
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .build()
        }
        logoDetail.setOnClickListener{
            var ngintenDetail = Intent(getActivity(),home::class.java)
            startActivity(ngintenDetail)
        }
    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_detail, container, false)
    }

}