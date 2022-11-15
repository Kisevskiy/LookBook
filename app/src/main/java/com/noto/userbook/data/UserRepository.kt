package com.noto.userbook.data

import androidx.lifecycle.LiveData
import com.noto.userbook.data.room.UserDao
import com.noto.userbook.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData:LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}