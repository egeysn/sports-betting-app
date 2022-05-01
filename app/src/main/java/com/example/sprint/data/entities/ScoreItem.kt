package com.example.sprint.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ScoreItem(
    val score: String?,
    val name: String?
) :Parcelable
