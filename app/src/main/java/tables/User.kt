package tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate=true)val id:Int?=null,
    @ColumnInfo(name = "fname")val fullName:String
)
