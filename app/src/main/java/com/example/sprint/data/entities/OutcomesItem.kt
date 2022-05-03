package com.example.sprint.data.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

import java.util.*



 class OutcomesItem(
    //TODO PARCELIZE OBJECT NOT SUPPORTING DEFAULT VALUES THROWING ERROR FIND A SOLUTION
    var id:String?  = UUID.randomUUID().toString(),

    @field:SerializedName("price")
    val price: Double?,

    @field:SerializedName("name")
    val name: String?
) : Serializable{

}

