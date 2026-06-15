package com.example.simulador

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simulador.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_HOME_TEAM = "extra_home_team"
        const val EXTRA_AWAY_TEAM = "extra_away_team"
        const val EXTRA_HOME_SCORE = "extra_home_score"
        const val EXTRA_AWAY_SCORE = "extra_away_score"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_HOME_LOGO = "extra_home_logo"
        const val EXTRA_AWAY_LOGO = "extra_away_logo"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val homeTeam = intent.getStringExtra(EXTRA_HOME_TEAM) ?: ""
        val awayTeam = intent.getStringExtra(EXTRA_AWAY_TEAM) ?: ""
        val homeScore = intent.getIntExtra(EXTRA_HOME_SCORE, 0)
        val awayScore = intent.getIntExtra(EXTRA_AWAY_SCORE, 0)
        val description = intent.getStringExtra(EXTRA_DESCRIPTION) ?: ""
        val homeLogo = intent.getIntExtra(EXTRA_HOME_LOGO, R.drawable.ic_escudo_vermelho)
        val awayLogo = intent.getIntExtra(EXTRA_AWAY_LOGO, R.drawable.ic_escudo_preto)

        binding.tvDescription.text = description
        binding.tvHomeTeamName.text = homeTeam
        binding.tvAwayTeamName.text = awayTeam
        binding.tvHomeTeamScore.text = homeScore.toString()
        binding.tvAwayTeamScore.text = awayScore.toString()
        binding.ivHomeTeam.setImageResource(homeLogo)
        binding.ivAwayTeam.setImageResource(awayLogo)

        supportActionBar?.title = "$homeTeam x $awayTeam"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
