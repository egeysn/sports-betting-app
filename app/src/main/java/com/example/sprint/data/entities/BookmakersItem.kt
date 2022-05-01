package com.example.sprint.data.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class BookmakersItem(

    @field:SerializedName("markets")
    val markets: List<MarketsItem?>? ,

    @field:SerializedName("last_update")
    val lastUpdate: String? ,

    @field:SerializedName("title")
    val title: String? ,

    @field:SerializedName("key")
    val key: String?
) : Parcelable
