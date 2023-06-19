package com.sevenyes.mysportteams.data.di

import com.sevenyes.mysportteams.data.network.repository.TeamsRepository
import com.sevenyes.mysportteams.data.network.repository.TeamsRepositoryImpl
import com.sevenyes.mysportteams.data.network.service.ApiServiceMetadata
import com.sevenyes.mysportteams.data.network.service.GradlePropertiesApiKeyServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Singleton
    @Binds
    abstract fun bindsTeamsRepository(impl: TeamsRepositoryImpl): TeamsRepository

    @Singleton
    @Binds
    abstract fun bindsApiServiceMetadata(impl: GradlePropertiesApiKeyServiceImpl): ApiServiceMetadata
}