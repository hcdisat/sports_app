package com.sevenyes.mysportteams.data.network.repository

import com.sevenyes.mysportteams.data.network.models.EventsResponse
import com.sevenyes.mysportteams.data.network.models.TeamsResponse
import com.sevenyes.mysportteams.data.network.service.ApiServiceMetadata
import com.sevenyes.mysportteams.data.network.service.EmptyBodyResponseException
import com.sevenyes.mysportteams.data.network.service.NotSuccessfulResponseException
import com.sevenyes.mysportteams.data.network.service.TeamsService
import retrofit2.Response
import javax.inject.Inject

sealed interface HttpResult<T> {
    data class Success<T>(val response: T) : HttpResult<T>
    data class Error<T>(val exception: Exception) : HttpResult<T>
}

interface TeamsRepository {
    suspend fun getLastEvents(teamId: String): HttpResult<EventsResponse>
    suspend fun getAllTeams(): HttpResult<TeamsResponse>
}

class TeamsRepositoryImpl @Inject constructor(
    private val apiServiceMetadata: ApiServiceMetadata,
    private val teamsService: TeamsService
) : TeamsRepository {
    override suspend fun getLastEvents(teamId: String): HttpResult<EventsResponse> =
        processResponse {
            teamsService.getLastEvents(
                apiKey = apiServiceMetadata.getApiKey(),
                teamId = teamId
            )
        }

    override suspend fun getAllTeams(): HttpResult<TeamsResponse> = processResponse {
        teamsService.getAllTeams(apiKey = apiServiceMetadata.getApiKey())
    }

    private inline fun <reified T> processResponse(call: () -> Response<T>): HttpResult<T> {
        return try {
            val response = call()

            if (response.isSuccessful) {
                response.body()?.let {
                    HttpResult.Success(it)
                } ?: HttpResult.Error(EmptyBodyResponseException())
            } else {
                HttpResult.Error(NotSuccessfulResponseException())
            }
        } catch (e: Exception) {
            HttpResult.Error(e)
        }
    }
}