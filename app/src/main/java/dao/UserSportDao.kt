package dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import tables.User
import tables.UserSport

@Dao
interface UserSportDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewUserSport(usersport:UserSport)

    @Query("SELECT * FROM usersport WHERE userid = :userid")
    fun getAllUserSports(userid : Int): LiveData<List<UserSport>>
}