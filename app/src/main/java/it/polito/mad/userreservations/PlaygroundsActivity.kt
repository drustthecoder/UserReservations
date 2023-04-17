package it.polito.mad.userreservations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class Playground(val name: String){

}

class PlaygroundsViewModel: ViewModel(){
    // Here we should query the business logic
    private val playgrounds = MutableLiveData<Int>().apply { value = 0 }
}

@AndroidEntryPoint
class PlaygroundsActivity : AppCompatActivity() {
    @Inject
    lateinit var bl: BusinessLogic
    val playgroundsList = listOf<Playground>(
        Playground("playground1"),
        Playground("playground2"),
        Playground("playground3"),
        Playground("playground4"),
        Playground("playground5"),
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