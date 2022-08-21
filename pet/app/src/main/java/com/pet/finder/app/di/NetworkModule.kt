package com.pet.finder.app.di

import com.pet.finder.app.data.remote.TokenAuthenticator
import com.pet.finder.app.data.remote.dataSource.RetrofitAnimalDataSource
import com.pet.finder.app.data.remote.dataSource.RetrofitAnimalDataSourceImpl
import com.pet.finder.app.data.remote.service.AnimalService
import com.pet.finder.app.data.remote.service.OrganizationService
import com.pet.finder.app.data.remote.service.SessionService
import com.pet.finder.app.data.remote.utils.BASE_URL
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        tokenAuthenticator: TokenAuthenticator
    ): OkHttpClient =
        OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .authenticator(tokenAuthenticator)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideSessionApi(retrofit: Retrofit): SessionService {
        return retrofit.create(SessionService::class.java)

    }

    @Singleton
    @Provides
    fun provideAnimalApi(retrofit: Retrofit): AnimalService =
        retrofit.create(AnimalService::class.java)

    @Singleton
    @Provides
    fun provideOrganizationApi(retrofit: Retrofit): OrganizationService =
        retrofit.create(OrganizationService::class.java)

    @Singleton
    @Provides
    fun provideRetrofitAnimalDataSource(
        animalService: AnimalService, organizationService: OrganizationService
    ): RetrofitAnimalDataSource {
        return RetrofitAnimalDataSourceImpl(
            animalService = animalService,
            organizationService = organizationService
        )
    }
}