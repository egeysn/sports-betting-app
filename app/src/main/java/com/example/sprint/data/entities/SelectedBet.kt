package com.example.sprint.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class SelectedBet(

    val id: String?,

    val price: Double?,

    val name: String?
) : Parcelable {

}

