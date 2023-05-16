package databaseHandlers

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dao.UserDao
import tables.User

@Database(entities = [User::class], version = 1)
abstract class SportDayDB : RoomDatabase() {
    abstract fun userDao() : UserDao

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