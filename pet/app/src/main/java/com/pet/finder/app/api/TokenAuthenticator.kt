package com.pet.finder.app.api

import com.pet.finder.app.api.servcice.SessionService
import com.pet.finder.app.api.session.SessionStorage
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject
import javax.inject.Provider

class TokenAuthenticator @Inject constructor(
    private val sessionService: Provider<SessionService>,
    private val sessionStorage: SessionStorage
) :
    Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        var token = sessionStorage.getToken()
        synchronized(this) {
            token = getUpdatedToken()
            return response.request.newBuilder()
                .header("Authorization", token)
                .build()
        }
    }

    private fun getUpdatedToken(): String {
        val tokenResponse = sessionService.get().updateToken().execute().body()
        val newToken = tokenResponse?.tokenType + " " + tokenResponse?.accessToken
        sessionStorage.refreshToken(newToken)
        return newToken
    }
}