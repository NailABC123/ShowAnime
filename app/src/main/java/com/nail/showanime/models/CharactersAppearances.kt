package com.nail.showanime.models

import com.google.gson.annotations.SerializedName

data class CharactersAppearances(
    @SerializedName("mal_id")
    var malId: Int = 0, // 17265
    @SerializedName("type")
    var type: String = "", // anime
    @SerializedName("name")
    var name: String = "", // Log Horizon
    @SerializedName("url")
    var url: String = "" // https://myanimelist.net/anime/17265/Log_Horizon
)
