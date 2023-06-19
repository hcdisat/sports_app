package com.sevenyes.mysportteams.teams.di

import com.sevenyes.mysportteams.teams.domain.usecase.GetTeamsUseCase
import com.sevenyes.mysportteams.teams.domain.usecase.GetTeamsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class TeamsModule {

    @Binds
    @ViewModelScoped
    abstract fun bindsGetTeamsUseCase(impl: GetTeamsUseCaseImpl): GetTeamsUseCase
}