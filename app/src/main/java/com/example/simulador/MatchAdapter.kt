package com.example.simulador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.simulador.databinding.MatchItemBinding

class MatchAdapter(
    private val matches: List<Match>,
    private val onItemClick: (Match) -> Unit
) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    inner class MatchViewHolder(private val binding: MatchItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(match: Match) {
            binding.txtTimeCasa.text = match.homeTeam
            binding.txtTimeVisitante.text = match.awayTeam
            binding.txtPlacaCasa.text = match.homeScore.toString()
            binding.txtPlacaVisitante.text = match.awayScore.toString()
            binding.root.setOnClickListener { onItemClick(match) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val binding = MatchItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(matches[position])
    }

    override fun getItemCount(): Int = matches.size
}
