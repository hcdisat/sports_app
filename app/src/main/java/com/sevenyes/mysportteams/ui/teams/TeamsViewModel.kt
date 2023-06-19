package com.sevenyes.mysportteams.ui.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sevenyes.mysportteams.events.domain.usecase.GetLastEventsForTeamUseCase
import com.sevenyes.mysportteams.teams.domain.usecase.GetTeamsUseCase
import com.sevenyes.mysportteams.ui.teams.model.TeamsEvent
import com.sevenyes.mysportteams.ui.teams.model.TeamsState
import com.sevenyes.mysportteams.ui.teams.model.UITeams
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    private val getTeams: GetTeamsUseCase,
    private val getLastEventsForTeam: GetLastEventsForTeamUseCase
) : ViewModel() {

    private val _uiState: MutableLiveData<TeamsState> = MutableLiveData(TeamsState.Loading)
    val uiState: LiveData<TeamsState> get() = _uiState

    fun onEvent(event: TeamsEvent) {
        when(event) {
            TeamsEvent.LoadTeams -> loadTeams()
            is TeamsEvent.LoadTeamEvents -> loadTeamEvents(event.teamId)
        }
    }

    private fun loadTeams() {
        viewModelScope.launch {
            val teams = withContext(Dispatchers.IO) {
                getTeams()
            }

            _uiState.value = TeamsState.Completed(UITeams(teams = teams))
        }
    }

    private fun loadTeamEvents(teamId: String) {
        viewModelScope.launch {
            val teams = withContext(Dispatchers.IO) {
                getLastEventsForTeam(teamId)
            }
        }
    }
}