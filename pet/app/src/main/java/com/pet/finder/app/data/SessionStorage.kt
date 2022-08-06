package com.pet.finder.app.data

interface SessionStorage {
//   suspend fun saveToken()

    suspend fun getToken(): String
    suspend fun refreshToken(token:String)
}