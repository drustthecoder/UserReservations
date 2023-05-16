package viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import databaseHandlers.SportDayDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import repositories.UserRepo
import tables.User

class UserViewModel(application: Application):AndroidViewModel(application) {
    private lateinit var userRepo : UserRepo

    init {
        val userDao = SportDayDB.getDatabase(application).userDao()
        userRepo = UserRepo(userDao)
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            userRepo.addUser(user)
        }
    }

    fun getAllUsers() : LiveData<List<User>>{
        return userRepo.getAllUsers()
    }

    fun getUserByFname(fname:String) : LiveData<User>{
        return userRepo.getUserByFname(fname)
    }


}