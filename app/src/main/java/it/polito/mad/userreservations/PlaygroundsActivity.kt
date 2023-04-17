package it.polito.mad.userreservations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@Entity(tableName = "Playgrounds")
data class Playground (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "type")
    val type: String
    )


@Dao
interface PlaygroundDao {
    @Query("SELECT * FROM Playgrounds")
    fun getAll() : List<Playground>
}


@Database(entities = [Playground::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun playgroundDao(): PlaygroundDao
}



//class Playground(val name: String){
//
//}

class PlaygroundsViewModel: ViewModel(){
    // Here we should query the business logic
    private val playgrounds = MutableLiveData<Int>().apply { value = 0 }


}

@AndroidEntryPoint
class PlaygroundsActivity : AppCompatActivity() {
//    val db = Room.databaseBuilder(
//        applicationContext,
//        AppDatabase::class.java, "database-name"
//    ).build()
//    val playgroundDao = db.playgroundDao()
//    val playgroundsList1: List<Playground> = playgroundDao.getAll()

    @Inject
    lateinit var bl: BusinessLogic
    val playgroundsList = listOf<Playground>(
        Playground(1, "football playground1", "football"),
        Playground(2, "football playground2", "football"),
        Playground(3, "volleyball playground3", "volleyball"),
        Playground(4, "volleyball playground4", "volleyball"),
        Playground(5, "volleyball playground5", "volleyball"),
        Playground(6, "football playground6", "football"),
        Playground(7, "football playground7", "football"),
        Playground(8, "volleyball playground8", "volleyball"),
        Playground(9, "volleyball playground9", "volleyball"),
        Playground(10, "volleyball playground10", "volleyball"),
    )
    val vm by viewModels<PlaygroundsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playgrounds)

        val playgroundsRecyclerView = findViewById<RecyclerView>(R.id.playgroundsRecyclerView)
        playgroundsRecyclerView.adapter = MyAdapter(playgroundsList)
        playgroundsRecyclerView.layoutManager = LinearLayoutManager(this)
    }

}

class MyViewHolder(v: View): RecyclerView.ViewHolder(v){
    val tv: TextView = v.findViewById<TextView>(R.id.playground_text)
}

class MyAdapter(val l: List<Playground>): RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.playground_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return l.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv.text = l[position].name
    }

}