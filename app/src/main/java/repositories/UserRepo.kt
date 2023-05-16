package repositories

import androidx.lifecycle.LiveData
import dao.UserDao
import tables.User

class UserRepo (val userDao: UserDao) {
    suspend fun addUser(user:User){
        userDao.insertNewUser(user)
    }

    fun getAllUsers() : LiveData<List<User>> {
        return userDao.getAllUsers()
    }
}