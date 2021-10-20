package com.example.dswap

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [homeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class homeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //logic yang sama kyk Activity biasa di sini
        super.onViewCreated(view, savedInstanceState)
        var resevation : Button = view.findViewById(R.id.btnresevation)
        var history    : Button = view.findViewById(R.id.history)

        resevation.setOnClickListener{
            var nginten = Intent(getActivity(),reservation::class.java)
            startActivity(nginten)
        }

        history.setOnClickListener{
            var nginten = Intent(getActivity(),History::class.java)
            startActivity(nginten)
        }

    }


}