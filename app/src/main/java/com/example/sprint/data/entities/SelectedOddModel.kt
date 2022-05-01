package com.example.sprint.data.entities

import com.google.gson.annotations.SerializedName

data class SelectedOddModel(

    val outCome : OutcomesItem?,

    val sportKey: String?,

    val id: String?,

    val homeTeam: String?,

    val sportTitle: String?,

    val commenceTime: String? ,

    val awayTeam: String? 
)

