package com.pet.finder.app.di

import com.pet.finder.app.api.dataSource.RetrofitAnimalDataSource
import com.pet.finder.app.api.dataSource.RetrofitAnimalDataSourceImpl
import com.pet.finder.app.api.dataSource.RetrofitSessionDataSource
import com.pet.finder.app.api.dataSource.RetrofitSessionDataSourceImpl
import com.pet.finder.app.api.servcice.AnimalService
import com.pet.finder.app.api.servcice.SessionService
import com.pet.finder.app.api.utils.BASE_URL
import com.pet.finder.app.data.SessionStorage
import dagger.Module
import dagger.Provides
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // @Singleton
    @Provides
    fun provideOkHttpClient() = okHttpClient

    //  @Singleton
    @Provides
    fun provideRetrofit() = retrofit

    //   @Singleton
    @Provides
    fun provideSessionApi(): SessionService = retrofit.create(SessionService::class.java)

    //  @Singleton
    @Provides
    fun provideAnimalApi(): AnimalService = retrofit.create(AnimalService::class.java)

    @Provides
    fun provideRetrofitAnimalDataSource(
        animalService: AnimalService,
        sessionStorage: SessionStorage
    ): RetrofitAnimalDataSource {
        return RetrofitAnimalDataSourceImpl(animalService, sessionStorage)
    }

    @Provides
    fun provideRetrofitSessionDataSource(
        sessionService: SessionService,
    ): RetrofitSessionDataSource {
        return RetrofitSessionDataSourceImpl(sessionService)
    }
}