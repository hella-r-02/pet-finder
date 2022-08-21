package com.pet.finder.app.data.remote

import com.pet.finder.app.data.remote.service.SessionService
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject
import javax.inject.Provider

class TokenAuthenticator @Inject constructor(
    private val sessionService: Provider<SessionService>
) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request {
        val token = getUpdatedToken()
        return response.request.newBuilder()
            .header("Authorization", token)
            .build()
    }

    private fun getUpdatedToken(): String {
        val tokenResponse = sessionService.get().updateToken().execute().body()
        return tokenResponse?.tokenType + " " + tokenResponse?.accessToken
    }
}