package com.example.dswap

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var logoDetail : Button = view.findViewById(R.id.logoDetail)
        var textfield = view.findViewById<TextInputLayout>(R.id.klinik)
//        val items = listOf("Material", "Design", "Components", "Android")// can set the list of drop down array in here
        val rs = resources.getStringArray(R.array.RumahSakit)//using list input of dropdown in the file string in arrray name RumahSakit
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_rs, rs)
        (textfield.editText as? AutoCompleteTextView)?.setAdapter(adapter)

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
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

}