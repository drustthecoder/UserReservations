package it.polito.mad.userreservations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import dagger.hilt.android.AndroidEntryPoint
import others.CurrentUser
import javax.inject.Inject

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {
    @Inject
    lateinit var currentUser : CurrentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profileFname = findViewById<EditText>(R.id.profileFname)
        currentUser.user.observe(this){
            profileFname.setText(it.fullName)
        }

        val addsportBtn = findViewById<Button>(R.id.addSportBtn)
        addsportBtn.setOnClickListener{
            startActivity(Intent(this, AddSportActivity::class.java))
        }
    }
}