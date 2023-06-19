package com.sevenyes.mysportteams.data.network.models


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("dateEvent")
    val dateEvent: String?,
    @SerializedName("dateEventLocal")
    val dateEventLocal: String?,
    @SerializedName("idAPIfootball")
    val idAPIfootball: String?,
    @SerializedName("idAwayTeam")
    val idAwayTeam: String?,
    @SerializedName("idEvent")
    val idEvent: String?,
    @SerializedName("idHomeTeam")
    val idHomeTeam: String?,
    @SerializedName("idLeague")
    val idLeague: String?,
    @SerializedName("intAwayScore")
    val intAwayScore: String?,
    @SerializedName("intHomeScore")
    val intHomeScore: String?,
    @SerializedName("intRound")
    val intRound: String?,
    @SerializedName("strAwayTeam")
    val strAwayTeam: String?,
    @SerializedName("strBanner")
    val strBanner: String?,
    @SerializedName("strCity")
    val strCity: String?,
    @SerializedName("strCountry")
    val strCountry: String?,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,
    @SerializedName("strEvent")
    val strEvent: String?,
    @SerializedName("strEventAlternate")
    val strEventAlternate: String?,
    @SerializedName("strFilename")
    val strFilename: String?,
    @SerializedName("strHomeTeam")
    val strHomeTeam: String?,
    @SerializedName("strLeague")
    val strLeague: String?,
    @SerializedName("strLocked")
    val strLocked: String?,
    @SerializedName("strPoster")
    val strPoster: String?,
    @SerializedName("strPostponed")
    val strPostponed: String?,
    @SerializedName("strResult")
    val strResult: String?,
    @SerializedName("strSeason")
    val strSeason: String?,
    @SerializedName("strSport")
    val strSport: String?,
    @SerializedName("strSquare")
    val strSquare: String?,
    @SerializedName("strStatus")
    val strStatus: String?,
    @SerializedName("strThumb")
    val strThumb: String?,
    @SerializedName("strTime")
    val strTime: String?,
    @SerializedName("strTimeLocal")
    val strTimeLocal: String?,
    @SerializedName("strTimestamp")
    val strTimestamp: String?,
    @SerializedName("strTweet1")
    val strTweet1: String?,
    @SerializedName("strTweet2")
    val strTweet2: String?,
    @SerializedName("strTweet3")
    val strTweet3: String?,
    @SerializedName("strVenue")
    val strVenue: String?,
    @SerializedName("strVideo")
    val strVideo: String?
)