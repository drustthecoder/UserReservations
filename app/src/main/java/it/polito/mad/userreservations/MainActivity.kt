package it.polito.mad.userreservations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
    }
}