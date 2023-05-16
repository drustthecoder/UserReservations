package it.polito.mad.userreservations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import others.CurrentUser
import tables.UserSport
import viewModels.UserSportViewModel
import viewModels.UserViewModel
import javax.inject.Inject

@AndroidEntryPoint
class AddSportActivity : AppCompatActivity() {

    @Inject
    lateinit var currentUser: CurrentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_sport)

        val userSportViewModel = ViewModelProvider(this)[UserSportViewModel::class.java]

        var userid = 0

        currentUser.user.observe(this){
            userid = it.id!!
        }

        val sportname = findViewById<EditText>(R.id.sportName)
        val sportlevel = findViewById<EditText>(R.id.sportLevel)
        val sportAchievements = findViewById<EditText>(R.id.sportAchievements)
        val submitBtn = findViewById<Button>(R.id.submitBtn)

        submitBtn.setOnClickListener{
            val newUserSport = UserSport(
                null, userid,
                sportname.text.toString(),
                sportAchievements.text.toString(),
                sportlevel.text.toString()
            )
            val userSport = userSportViewModel.addUserSport(newUserSport)
            finish()
        }

    }
}