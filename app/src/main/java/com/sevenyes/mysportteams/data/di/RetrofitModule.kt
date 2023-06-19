package com.sevenyes.mysportteams.data.di

import com.sevenyes.mysportteams.BuildConfig
import com.sevenyes.mysportteams.data.network.service.ApiServiceMetadata
import com.sevenyes.mysportteams.data.network.service.TeamsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            builder.addInterceptor(loggingInterceptor)
        }

        return builder
            .callTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun providesTeamsService(
        okHttpClient: OkHttpClient,
        apiServiceMetadata: ApiServiceMetadata
    ): TeamsService {
        return Retrofit.Builder()
            .baseUrl(apiServiceMetadata.getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(TeamsService::class.java)
    }
}