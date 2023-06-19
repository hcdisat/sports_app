package com.sevenyes.mysportteams.data.network.service

import com.sevenyes.mysportteams.common.ApiConstants
import com.sevenyes.mysportteams.data.network.models.EventsResponse
import com.sevenyes.mysportteams.data.network.models.TeamsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TeamsService {
    @GET("{key}/eventslast.php")
    suspend fun getLastEvents(
        @Path("key") apiKey: String,
        @Query("id") teamId: String
    ): Response<EventsResponse>

    @GET("{key}/lookup_all_teams.php")
    suspend fun getAllTeams(
        @Path("key") apiKey: String,
        @Query("id") idLeague: String = ApiConstants.LEAGUE_ID
    ): Response<TeamsResponse>
}