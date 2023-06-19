package com.sevenyes.mysportteams.events.domain.usecase

import com.sevenyes.mysportteams.data.network.repository.HttpResult
import com.sevenyes.mysportteams.data.network.repository.TeamsRepository
import com.sevenyes.mysportteams.events.domain.extensions.toDomainEvent
import com.sevenyes.mysportteams.events.domain.models.DomainEvent
import javax.inject.Inject

interface GetLastEventsForTeamUseCase {
    suspend operator fun invoke(teamId: String): List<DomainEvent>
}

class GetLastEventsForTeamUseCaseImpl @Inject constructor(
    private val teamsRepository: TeamsRepository
) : GetLastEventsForTeamUseCase {
    override suspend fun invoke(teamId: String): List<DomainEvent> {
        return when(val result = teamsRepository.getLastEvents(teamId)) {
            is HttpResult.Error -> {
                // Here you must try to let the view model know that it has to show some kind of UI error
                result.exception.printStackTrace()
                throw result.exception
            }
            is HttpResult.Success -> {
                result.response.results.map { it.toDomainEvent() }
            }
        }
    }
}