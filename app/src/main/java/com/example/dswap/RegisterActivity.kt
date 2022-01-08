package com.example.dswap

//import com.google.firebase.firestore.auth.User
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dswap.UserBackEnd.User
import com.google.firebase.database.FirebaseDatabase
import com.kofigyan.stateprogressbar.StateProgressBar

class RegisterActivity : AppCompatActivity() {
    protected var descriptionData = arrayOf("Registration", "Detail", "Payment")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var logoRegist: Button = findViewById(R.id.logoRegist)
        var btnnextregis: Button = findViewById(R.id.btnNextRegist)
        var btnCancelRegist:Button = findViewById(R.id.btnCancelRegist)
        var emailRegist: EditText = findViewById(R.id.email) // ngisi email
        var FullName: EditText = findViewById(R.id.namaLengkap) // ngisi nama lengkap
        var Password: EditText = findViewById(R.id.pass)//ngisi password
        var confirmPass: EditText = findViewById(R.id.passConfirm)
        var noTelp: EditText = findViewById(R.id.noTelp)

        var stateprogressbar = findViewById<View>(R.id.state_progress_bar_id) as StateProgressBar
        stateprogressbar.setStateDescriptionData(descriptionData)

        logoRegist.setOnClickListener {
            val ngintenRegist = Intent(this, home::class.java)
            startActivity(ngintenRegist)
        }

        btnnextregis.setOnClickListener {
            if (!emailRegist.text.toString().contains("@")) {
                Toast.makeText(this, "Email must be valid", Toast.LENGTH_SHORT).show()
                emailRegist.error = "input valid Email using @"
            } else if (Password.text.toString() != confirmPass.text.toString()) {
                confirmPass.error = "please match your matching password"
            } else { // masukin data ke dalam firebase (backend)

                val Fullname = FullName.text.toString().trim()
                val Phone = noTelp.text.toString().trim()
                val Email = emailRegist.text.toString().trim().replace(".",",")

                val PASS = confirmPass.text.toString().trim()

                val SimpanData =
                    FirebaseDatabase.getInstance("https://dswap-a3b71-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("user")// bikin tabel user
                var UserID = SimpanData.push().key
                val user = User(UserID,Fullname, Phone, Email, PASS)
                if (UserID != null) {
                    SimpanData.child(Email).setValue(user).addOnSuccessListener {
                        Toast.makeText(this, "data input succsess", Toast.LENGTH_SHORT).show()
                    }.addOnFailureListener {
                        Toast.makeText(this, "data input fail", Toast.LENGTH_SHORT).show()
                    }
                }
                val Inten = Intent(this, DetailActivity::class.java)
                Inten.putExtra(DetailActivity.EXTRA_name, Email)
                startActivity(Inten)
            }

        }

        btnCancelRegist.setOnClickListener{
            val intenRegist = Intent(this, home::class.java)
            startActivity(intenRegist)
        }
    }
}