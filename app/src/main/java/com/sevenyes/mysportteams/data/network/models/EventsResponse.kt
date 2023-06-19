package com.sevenyes.mysportteams.data.network.models


import com.google.gson.annotations.SerializedName

data class EventsResponse(
    @SerializedName("results")
    val results: List<Event>
)