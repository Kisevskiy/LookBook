package com.noto.userbook.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noto.userbook.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData():LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)
}