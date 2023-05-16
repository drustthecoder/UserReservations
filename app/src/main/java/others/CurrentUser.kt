package others

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import tables.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrentUser
@Inject
constructor() {
    private val currentUser = User(99, "Some user")
    private val _user = MutableLiveData(currentUser)
    val user: LiveData<User> = _user


    fun setUser(user: User){
        _user.value = user
    }
}