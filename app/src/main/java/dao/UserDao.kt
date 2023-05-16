package dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tables.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewUser(user:User)

    @Query("SELECT * FROM user")
    fun getAllUsers():LiveData<List<User>>

    @Query("SELECT * FROM user WHERE fname = :fname")
    fun getUserByFname(fname:String):LiveData<User>
}