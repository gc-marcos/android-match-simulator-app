package com.example.simulador

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simulador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val matches = mutableListOf<Match>()
    private lateinit var adapter: MatchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMatches()
        setupRecyclerView()
        setupFab()
    }

    private fun setupMatches() {
        matches.addAll(
            listOf(
                Match("Flamengo", "Corinthians", description = "Clássico Nacional"),
                Match("Palmeiras", "São Paulo", description = "Derby Paulista"),
                Match("Grêmio", "Internacional", description = "Grenal"),
                Match("Atlético MG", "Cruzeiro", description = "Clássico Mineiro")
            )
        )
    }

    private fun setupRecyclerView() {
        adapter = MatchAdapter(matches) { match ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.EXTRA_HOME_TEAM, match.homeTeam)
                putExtra(DetailActivity.EXTRA_AWAY_TEAM, match.awayTeam)
                putExtra(DetailActivity.EXTRA_HOME_SCORE, match.homeScore)
                putExtra(DetailActivity.EXTRA_AWAY_SCORE, match.awayScore)
                putExtra(DetailActivity.EXTRA_DESCRIPTION, match.description)
            }
            startActivity(intent)
        }

        binding.rvMatches.layoutManager = LinearLayoutManager(this)
        binding.rvMatches.adapter = adapter

        binding.srlMatches.setOnRefreshListener {
            resetScores()
            binding.srlMatches.isRefreshing = false
        }
    }

    private fun setupFab() {
        binding.fabsimulate.setOnClickListener {
            simulateMatches()
        }
    }

    private fun simulateMatches() {
        matches.forEach { match ->
            match.homeScore = (0..5).random()
            match.awayScore = (0..5).random()
        }
        adapter.notifyDataSetChanged()
    }

    private fun resetScores() {
        matches.forEach { match ->
            match.homeScore = 0
            match.awayScore = 0
        }
        adapter.notifyDataSetChanged()
    }
}
