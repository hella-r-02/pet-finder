package com.pet.finder.app.di

import com.pet.finder.app.api.TokenAuthenticator
import com.pet.finder.app.api.dataSource.RetrofitAnimalDataSource
import com.pet.finder.app.api.dataSource.RetrofitAnimalDataSourceImpl
import com.pet.finder.app.api.servcice.AnimalService
import com.pet.finder.app.api.servcice.SessionService
import com.pet.finder.app.api.utils.BASE_URL
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
    fun provideRetrofitAnimalDataSource(
        animalService: AnimalService
    ): RetrofitAnimalDataSource {
        return RetrofitAnimalDataSourceImpl(animalService)
    }
}