package adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import it.polito.mad.userreservations.ProfileActivity
import it.polito.mad.userreservations.R
import tables.UserSport

class UserSportAdapter(private val activity: ProfileActivity): RecyclerView.Adapter<UserSportViewHolder>() {

    private var listOfUserSports = emptyList<UserSport>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserSportViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.usersport_layout, parent, false)
        return UserSportViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listOfUserSports.size
    }

    override fun onBindViewHolder(holder: UserSportViewHolder, position: Int) {
        val userSport = listOfUserSports[position]
        holder.bind(userSport, activity)
    }

    fun setData(listOfUserSports : List<UserSport>){
        this.listOfUserSports = listOfUserSports
        notifyDataSetChanged()
    }
}

class UserSportViewHolder(v: View): RecyclerView.ViewHolder(v){
    private val usersportname: TextView = v.findViewById(R.id.usersportname)
    private val usersportlevel: TextView = v.findViewById((R.id.usersportlevel))
    private val usersportachievements: TextView = v.findViewById(R.id.usersportachievements)

    fun bind(userSport : UserSport, activity: ProfileActivity){
        usersportname.text = userSport.sportName
        usersportlevel.text = userSport.level
        usersportachievements.text = userSport.achievements
//        tv.text = user.fullName
//        btn.setOnClickListener{
//            val reservationsIntent = Intent(activity, MainActivity::class.java)
//            reservationsIntent.putExtra("name",user.fullName)
//            ContextCompat.startActivity(activity, reservationsIntent, null)
//        }
    }
}