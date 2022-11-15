package com.noto.userbook.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.noto.userbook.data.room.UserDataBase
import com.noto.userbook.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {

     val readAllData:LiveData<List<User>>
    private val repository:UserRepository

    init {
        val userDao = UserDataBase.getDataBase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}