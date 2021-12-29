package com.example.dswap

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dswap.PatientBackEnd.Patient
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.FirebaseDatabase
import com.kofigyan.stateprogressbar.StateProgressBar


class DetailActivity : AppCompatActivity() {
    protected var descriptionData = arrayOf("Registration", "Detail", "Payment")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var logoDetail: Button = findViewById(R.id.logoDetail)
        //Input text
        var namePatient = findViewById<EditText>(R.id.patientName)
        var textNIK = findViewById<EditText>(R.id.Nik)
        var textTypeTest = findViewById<AutoCompleteTextView>(R.id.jenisTesBtn)
        var datefield = findViewById<EditText>(R.id.tanggalTes)
        var AddressText = findViewById<EditText>(R.id.alamatTes)
        var textKlinik = findViewById<AutoCompleteTextView>(R.id.klinikInput)

        //button
        var submitBtn = findViewById<Button>(R.id.btnSubmitDetail)
        var btnBack = findViewById<Button>(R.id.btnCancelRegist)

        //progress bar
        var stateprogressbarDetail =
            findViewById<View>(R.id.state_progress_bar_id) as StateProgressBar
        stateprogressbarDetail.setStateDescriptionData(descriptionData)

//
//      val items = listOf("Material", "Design", "Components", "Android")// can set the list of drop down array in here
        val rs =
            resources.getStringArray(R.array.RumahSakit)//using list input of dropdown in the file string in arrray name RumahSakit
        val rsAdapter = ArrayAdapter(this, R.layout.dropdown_template, rs)
        textKlinik.setAdapter(rsAdapter)

        val tes = resources.getStringArray(R.array.JenisTes)
        val tesAdapter = ArrayAdapter(this, R.layout.dropdown_template, tes)
//        (textTypeTest.editText as? AutoCompleteTextView)?.setAdapter(tesAdapter)
        textTypeTest.setAdapter(tesAdapter)

        datefield.setOnClickListener() {
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .build()
        }

        logoDetail.setOnClickListener {
            var ngintenDetail = Intent(this, home::class.java)
            startActivity(ngintenDetail)
        }
        submitBtn.setOnClickListener {

            val NamePatients = namePatient.text.toString().trim()
            val NIK = textNIK.text.toString().trim()
            val TestType = textTypeTest.text.toString().trim()
            val TestDate = datefield.text.toString().trim()
            val Address = AddressText.text.toString().trim()
            val Clinic = textKlinik.text.toString().trim()

            val data =
                FirebaseDatabase.getInstance("https://dswap-a3b71-default-rtdb.asia-southeast1.firebasedatabase.app/")
                    .getReference("Patients")// bikin tabel user
            val pasien = Patient(NamePatients, NIK, TestType, TestDate, Address, Clinic)

            data.child(NamePatients).setValue(pasien).addOnSuccessListener {
                Toast.makeText(this, "data input succsess", Toast.LENGTH_SHORT).show()
            }

            var IntenNextToPay = Intent(this, PayActivity::class.java)
            startActivity(IntenNextToPay)
        }

        btnBack.setOnClickListener {
            var intenBackToRegist = Intent(this, RegisterActivity::class.java)
            startActivity(intenBackToRegist)
        }
    }
}