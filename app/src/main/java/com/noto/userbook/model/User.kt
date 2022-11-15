package com.noto.userbook.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    @ColumnInfo
    val age:Int ,
    @ColumnInfo
    val firstName:String,
    @ColumnInfo
    val lastName:String,
)
