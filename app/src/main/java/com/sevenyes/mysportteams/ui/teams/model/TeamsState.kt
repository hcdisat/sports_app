package com.sevenyes.mysportteams.ui.teams.model

import com.sevenyes.mysportteams.teams.domain.models.DomainTeam

sealed class TeamsState {
    object Loading: TeamsState()
    data class Completed(val uiTeams: UITeams = UITeams()): TeamsState()
}

data class UITeams(val teams: List<DomainTeam> = listOf())