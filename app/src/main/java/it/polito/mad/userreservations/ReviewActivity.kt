package it.polito.mad.userreservations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ReviewActivity : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val rBar = findViewById<RatingBar>(R.id.ratingBar)
        val rText = findViewById<EditText>(R.id.reviewText)
        val submitReviewBtn = findViewById<Button>(R.id.submitReviewBtn)
        submitReviewBtn.setOnClickListener {

            val playgroundId = 1
            val userId = 1
            val score = rBar.rating
            val reviewText = rText.text.toString()

            val review = hashMapOf(
                "playgroundId" to playgroundId,
                "userId"  to userId,
                "score" to score,
                "reviewText" to reviewText
            )

            db.collection("reviews")
                .add(review)
                .addOnSuccessListener { documentReference ->
                    run {
                        Toast.makeText(applicationContext, "Review added!", Toast.LENGTH_SHORT)
                            .show()
                        finish()
                    }
                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext, "Failed!", Toast.LENGTH_SHORT).show()
                }
        }


    }
}