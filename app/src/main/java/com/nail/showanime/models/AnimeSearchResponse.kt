package com.nail.showanime.models

import com.google.gson.annotations.SerializedName

class AnimeSearchResponse (

    @SerializedName("results")
    var animeResults: List<AnimeClass> = listOf()

): BaseSearchResponse()