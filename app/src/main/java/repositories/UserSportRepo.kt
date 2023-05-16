package repositories

import androidx.lifecycle.LiveData
import dao.UserDao
import dao.UserSportDao
import tables.User
import tables.UserSport

class UserSportRepo(val userSportDao: UserSportDao) {
    suspend fun addUserSport(userSport: UserSport){
        userSportDao.insertNewUserSport(userSport)
    }

    fun getAllUserSports(userid:Int) : LiveData<List<UserSport>>{
        return userSportDao.getAllUserSports(userid)
    }
}