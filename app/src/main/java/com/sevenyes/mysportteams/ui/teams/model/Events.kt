package com.sevenyes.mysportteams.ui.teams.model

sealed class TeamsEvent {
    object LoadTeams: TeamsEvent()
    data class LoadTeamEvents(val teamId: String): TeamsEvent()
}