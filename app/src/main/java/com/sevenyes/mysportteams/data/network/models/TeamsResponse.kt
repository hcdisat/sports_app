package com.sevenyes.mysportteams.data.network.models


import com.google.gson.annotations.SerializedName

data class TeamsResponse(
    @SerializedName("teams")
    val teams: List<Team>
)