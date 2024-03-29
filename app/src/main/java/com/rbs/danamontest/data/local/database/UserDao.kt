package com.rbs.danamontest.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rbs.danamontest.data.local.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: UserEntity)

    @Query("UPDATE userentity SET username = :username WHERE id = :id")
    fun update(id: Int, username: String)

    @Query("DELETE FROM userentity WHERE id = :id")
    fun delete(id: Int)

    @Query("SELECT * from userentity WHERE role = 'Normal User' ORDER BY id ASC")
    fun getAllData(): LiveData<List<UserEntity>>

    @Query("SELECT * from userentity WHERE email = :email AND password = :password")
    fun checkUserAvailability(email: String, password: String): LiveData<UserEntity>
}