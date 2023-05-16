package databaseHandlers

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dao.UserDao
import dao.UserSportDao
import tables.User
import tables.UserSport

@Database(entities = [User::class, UserSport::class], version = 1)
abstract class SportDayDB : RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun userSportDao() : UserSportDao

    companion object {
        @Volatile
        private var INSTANCE: SportDayDB? = null
        fun getDatabase(context: Context): SportDayDB =
            (INSTANCE ?: synchronized(this) {
                val i = INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SportDayDB::class.java,
                    "sportdaydb"
                ).build()
                INSTANCE = i
                INSTANCE
            })!!
    }
}