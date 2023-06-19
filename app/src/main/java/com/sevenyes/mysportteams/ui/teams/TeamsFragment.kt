package com.sevenyes.mysportteams.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sevenyes.mysportteams.databinding.FragmentTeamsBinding
import com.sevenyes.mysportteams.ui.teams.model.TeamsEvent
import com.sevenyes.mysportteams.ui.teams.model.TeamsState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamsFragment : Fragment() {

    companion object {
        fun newInstance() = TeamsFragment()
    }

    private val viewModel: TeamsViewModel by viewModels()

    private var _binding: FragmentTeamsBinding? = null
    private val binding: FragmentTeamsBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onEvent(TeamsEvent.LoadTeams)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTeamsBinding.inflate(inflater, container, false)
        viewModel.uiState.observe(this, ::handleStateChanged)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun handleStateChanged(state: TeamsState) {
        when(state) {
            is TeamsState.Completed -> {
                toggleLoading(isOn = false)
                binding.teamsSize.text = state.uiTeams.teams.size.toString()
                viewModel.onEvent(TeamsEvent.LoadTeamEvents("134865"))
            }
            TeamsState.Loading -> toggleLoading()
        }
    }

    private fun View.show() { visibility = View.VISIBLE }

    private fun View.gone() { visibility = View.GONE }

    private fun toggleLoading(isOn: Boolean = true) {
        if (isOn) {
            binding.progressBar.show()
            binding.teamsSize.gone()
        } else {
            binding.progressBar.gone()
            binding.teamsSize.show()
        }
    }
}