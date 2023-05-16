package tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@kotlinx.serialization.Serializable
@Entity(tableName = "usersport")
data class UserSport(@PrimaryKey(autoGenerate = true)var id:Int?= null,
                @ColumnInfo(name = "userid")var userid: Int,
                @ColumnInfo(name = "sportname")var sportName:String,
                @ColumnInfo(name = "achievements")var achievements: String,
                @ColumnInfo(name = "level")var level: String) {

}