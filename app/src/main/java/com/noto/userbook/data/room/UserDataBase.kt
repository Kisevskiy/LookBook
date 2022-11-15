package com.noto.userbook.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.noto.userbook.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase:RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDataBase? = null

        fun getDataBase(context: Context): UserDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}