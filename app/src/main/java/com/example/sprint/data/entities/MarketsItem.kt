package com.example.sprint.data.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable


data class MarketsItem(

    @field:SerializedName("outcomes")
    val outcomes: List<OutcomesItem?>?,

    @field:SerializedName("key")
    val key: String?
) : Serializable

