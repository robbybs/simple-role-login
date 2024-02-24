package com.rbs.danamontest.domain.usecase

import androidx.lifecycle.LiveData
import com.rbs.danamontest.data.local.entity.UserEntity

interface UserUseCase {
    fun insertUsers(user: UserEntity)

    fun checkDataByEmail(email: String): LiveData<UserEntity>

    suspend fun saveUserSession(isUserLogin: Boolean)

    suspend fun saveRole(role: String)

    suspend fun savePassword(password: String)

    fun getUserSession(): LiveData<Boolean>

    fun getRole(): LiveData<String>
}