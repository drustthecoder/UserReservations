package it.polito.mad.userreservations

import adapters.UserSportAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import others.CurrentUser
import viewModels.UserSportViewModel
import javax.inject.Inject

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {
    @Inject
    lateinit var currentUser : CurrentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val userSportViewModel = ViewModelProvider(this)[UserSportViewModel::class.java]

        val profileFname = findViewById<EditText>(R.id.profileFname)
        currentUser.user.observe(this){
            profileFname.setText(it.fullName)
        }

        val addsportBtn = findViewById<Button>(R.id.addSportBtn)
        addsportBtn.setOnClickListener{
            startActivity(Intent(this, AddSportActivity::class.java))
        }

        var userid = 1

        currentUser.user.observe(this){
            userid = it.id!!
            Log.d("DEBUG", "userid is $userid")
        }

        val listOfUserSports = userSportViewModel.getAllUserSports(userid)

        val userSportRecyclerView = findViewById<RecyclerView>(R.id.userSportRecyclerView)
        var userSportAdapter = UserSportAdapter(this)
        userSportRecyclerView.adapter = userSportAdapter

        listOfUserSports.observe(this) {
            userSportAdapter.setData(it!!)
            Log.d("DEBUG", it.size.toString())
        }
        userSportRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}