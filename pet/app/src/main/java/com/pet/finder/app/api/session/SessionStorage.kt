package com.pet.finder.app.api.session

interface SessionStorage {
    fun refreshToken(token: String)

    fun getToken(): String
}