package it.polito.mad.userreservations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import tables.User
import viewModels.UserViewModel



class MainActivity : AppCompatActivity() {

    private lateinit var uservm : UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        uservm = ViewModelProvider(this)[UserViewModel::class.java]

        // get user

        //if not exists

        //create user





//        uservm.addUser(User(null, "Shayan"))
//        uservm.addUser(User(null, "Shayan1"))
//        uservm.addUser(User(null, "Shayan2"))
//        uservm.addUser(User(null, "Shayan3"))
//        uservm.addUser(User(null, "Shayan4"))
//        uservm.addUser(User(null, "Shayan8"))
//        uservm.addUser(User(null, "Shayan9"))

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val reservationsBtn = findViewById<Button>(R.id.reservationsBtn)
        reservationsBtn.setOnClickListener(){
            val reservationsIntent = Intent(this, ReservationsActivity::class.java)
            startActivity(reservationsIntent)
        }

        val playgroundsBtn = findViewById<Button>(R.id.playgroundsBtn)
        playgroundsBtn.setOnClickListener(){
            val playgroundsIntent = Intent(this, PlaygroundsActivity::class.java)
            startActivity(playgroundsIntent)
        }

        val profileBtn = findViewById<Button>(R.id.profileBtn)
        profileBtn.setOnClickListener(){
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}