package com.example.sprint.data.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OddModel(

	@field:SerializedName("bookmakers")
	val bookmakers: List<BookmakersItem?>? = null,

	@field:SerializedName("sport_key")
	val sportKey: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("home_team")
	val homeTeam: String? = null,

	@field:SerializedName("sport_title")
	val sportTitle: String? = null,

	@field:SerializedName("commence_time")
	val commenceTime: String? = null,

	@field:SerializedName("away_team")
	val awayTeam: String? = null
) : Parcelable

