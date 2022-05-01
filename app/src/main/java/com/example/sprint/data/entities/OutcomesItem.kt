package com.example.sprint.data.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OutcomesItem(
    @field:SerializedName("price")
    val price: Double? ,

    @field:SerializedName("name")
    val name: String?
) : Parcelable

