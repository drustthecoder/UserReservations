package viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import databaseHandlers.SportDayDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import repositories.UserRepo
import repositories.UserSportRepo
import tables.User
import tables.UserSport

class UserSportViewModel(application: Application):AndroidViewModel(application) {

    private lateinit var userSportRepo : UserSportRepo

    init {
        val userSportDao = SportDayDB.getDatabase(application).userSportDao()
        userSportRepo = UserSportRepo(userSportDao)
    }

    fun addUserSport(user: User, userSport:UserSport){
        viewModelScope.launch(Dispatchers.IO) {
            userSportRepo.addUserSport(userSport)
        }
    }

    fun getAllUserSports(userid:Int) : LiveData<List<UserSport>> {
        return userSportRepo.getAllUserSports(userid)
    }
}