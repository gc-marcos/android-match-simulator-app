package com.example.simulador

import androidx.annotation.DrawableRes

data class Match(
    val homeTeam: String,
    val awayTeam: String,
    var homeScore: Int = 0,
    var awayScore: Int = 0,
    val description: String = "",
    @DrawableRes val homeTeamLogo: Int = R.drawable.ic_escudo_vermelho,
    @DrawableRes val awayTeamLogo: Int = R.drawable.ic_escudo_preto
)
