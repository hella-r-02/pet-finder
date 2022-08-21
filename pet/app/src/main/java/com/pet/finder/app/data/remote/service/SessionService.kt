package com.pet.finder.app.data.remote.service

import com.pet.finder.app.data.remote.model.SessionResponse
import com.pet.finder.app.data.remote.utils.CLIENT_ID
import com.pet.finder.app.data.remote.utils.CLIENT_SECRET
import com.pet.finder.app.data.remote.utils.GRANT_TYPE
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SessionService {
    @POST("oauth2/token")
    @FormUrlEncoded
    fun updateToken(
        @Field("grant_type") grantType: String = GRANT_TYPE,
        @Field("client_id") clientId: String = CLIENT_ID,
        @Field("client_secret") clientSecret: String = CLIENT_SECRET
    ): Call<SessionResponse>
}