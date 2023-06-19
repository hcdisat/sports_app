package com.sevenyes.mysportteams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sevenyes.mysportteams.ui.teams.TeamsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TeamsFragment.newInstance())
                .commitNow()
        }
    }
}