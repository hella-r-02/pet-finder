package com.pet.finder.app.data.storage.sharedprefs

import android.content.Context
import com.pet.finder.app.api.dataSource.RetrofitSessionDataSource
import com.pet.finder.app.data.SessionStorage

private const val SHARED_PREF_NAME = "session_shared_pref"
private const val KEY = "token"

class SessionStorageImpl(
    context: Context,
    val retrofitSessionDataSource: RetrofitSessionDataSource
) :
    SessionStorage {
    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)

    override suspend fun getToken(): String {
        val token = sharedPreferences.getString(KEY, null)
        if (token == null) {
            val session = retrofitSessionDataSource.getToken()
            val newToken = session.tokenType + " " + session.accessToken
            sharedPreferences.edit().putString(KEY, newToken)
                .apply()
            return newToken
        }
        return token
    }

    override suspend fun refreshToken(token: String) {
    }
}