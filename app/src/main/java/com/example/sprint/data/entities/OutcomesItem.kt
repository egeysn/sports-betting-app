package com.example.sprint.data.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class OutcomesItem(
    //TODO PARCELIZE OBJECT NOT SUPPORTING DEFAULT VALUES THROWING ERROR FIND A SOLUTION
    val betId:String? = UUID.randomUUID().toString(),

    @field:SerializedName("price")
    val price: Double?,

    @field:SerializedName("name")
    val name: String?
) : Parcelable

