package com.pet.finder.app.api.dataSource

import com.pet.finder.app.api.servcice.SessionService
import com.pet.finder.app.data.model.Session
import javax.inject.Inject

class RetrofitSessionDataSourceImpl @Inject constructor(
    private val sessionService: SessionService
) : RetrofitSessionDataSource {
    override suspend fun getToken(): Session {
        val response = sessionService.getToken()
        return Session(
            tokenType = response.tokenType,
            accessToken = response.accessToken,
            expiresIn = response.expiresIn
        )
    }
}