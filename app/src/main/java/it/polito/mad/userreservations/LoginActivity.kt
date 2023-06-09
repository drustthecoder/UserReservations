package it.polito.mad.userreservations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import others.CurrentUser
import tables.User
import viewModels.UserViewModel
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {



    @Inject
    lateinit var currentUser : CurrentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        val fname = findViewById<EditText>(R.id.fname)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        loginBtn.setOnClickListener {
            val user = userViewModel.getUserByFname(fname.text.toString())
            user.observe(this){
                if (it != null && it != currentUser.user.value)
                {
                    currentUser.setUser(it)
                    startActivity(Intent(this, MainActivity::class.java))
                }
                else{
                    Toast.makeText(applicationContext, "User does not exist!", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val createBtn = findViewById<Button>(R.id.createBtn)
        createBtn.setOnClickListener{
            userViewModel.addUser(User(null, fname.text.toString()))
            Toast.makeText(applicationContext, "User created! Now you can log in!", Toast.LENGTH_SHORT).show()
        }
    }
}