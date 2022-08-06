package com.pet.finder.app.api.dataSource

import com.pet.finder.app.data.model.Session

interface RetrofitSessionDataSource {
   suspend fun getToken(): Session
}