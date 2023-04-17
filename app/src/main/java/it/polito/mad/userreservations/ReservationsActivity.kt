package it.polito.mad.userreservations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReservationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservations)

        val modifyBtn = findViewById<Button>(R.id.modifyBtn)
        val deleteBtn = findViewById<Button>(R.id.deleteBtn)

        modifyBtn.setOnClickListener(){
            startActivity(Intent(this, ModifyActivity::class.java))
        }
        deleteBtn.setOnClickListener(){
            startActivity(Intent(this, DeleteActivity::class.java))
        }
    }
}