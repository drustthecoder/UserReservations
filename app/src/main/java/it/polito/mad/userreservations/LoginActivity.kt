package it.polito.mad.userreservations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
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

        // create a user if no user exists
//        val user = userViewModel.getUserByFname("Shayan")
//        user.observe(this){
//            if (it == null)
//            {
//                userViewModel.addUser(User(null, "Shayan"))
//            }
//        }


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
                    Toast.makeText(applicationContext, "User does not exist", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}