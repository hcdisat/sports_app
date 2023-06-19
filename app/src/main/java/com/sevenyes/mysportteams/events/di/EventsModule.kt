package com.sevenyes.mysportteams.events.di

import com.sevenyes.mysportteams.events.domain.usecase.GetLastEventsForTeamUseCase
import com.sevenyes.mysportteams.events.domain.usecase.GetLastEventsForTeamUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class EventsModule {

    @Binds
    @ViewModelScoped
    abstract fun bindsGetLastEventsForTeamUseCase(
        impl: GetLastEventsForTeamUseCaseImpl
    ): GetLastEventsForTeamUseCase
}