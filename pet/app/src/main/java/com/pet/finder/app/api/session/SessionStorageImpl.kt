package com.pet.finder.app.api.session

import android.content.Context

private const val SHARED_PREF_NAME = "session_shared_pref"
private const val KEY = "token"

class SessionStorageImpl(
    context: Context
) :
    SessionStorage {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override fun refreshToken(token: String) {
        sharedPreferences.edit().putString(KEY, token).apply()
    }

    override fun getToken(): String {
        return sharedPreferences.getString(KEY, "") ?: ""
    }
}