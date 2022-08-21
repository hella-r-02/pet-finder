package com.pet.finder.app.data.remote.session

interface SessionStorage {
    fun refreshToken(token: String)

    fun getToken(): String
}