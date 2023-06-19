package com.sevenyes.mysportteams.teams.domain.usecase

import com.sevenyes.mysportteams.data.network.repository.HttpResult
import com.sevenyes.mysportteams.data.network.repository.TeamsRepository
import com.sevenyes.mysportteams.teams.domain.extensions.toDomainTeam
import com.sevenyes.mysportteams.teams.domain.models.DomainTeam
import javax.inject.Inject

interface GetTeamsUseCase {
    suspend operator fun invoke(): List<DomainTeam>
}

class GetTeamsUseCaseImpl @Inject constructor (
    private val teamsRepository: TeamsRepository
): GetTeamsUseCase {
    override suspend fun invoke(): List<DomainTeam> {
        return when(val result = teamsRepository.getAllTeams()) {
            is HttpResult.Error -> {
                // Here you must try to let the view model know that it has to show some kind of UI error
                result.exception.printStackTrace()
                throw result.exception
            }
            is HttpResult.Success -> {
                result.response.teams.map { it.toDomainTeam() }
            }
        }
    }
}