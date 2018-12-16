package com.nail.showanime.models

import com.google.gson.annotations.SerializedName

data class MangaSearchResponse(
    @SerializedName("results")
    var results: List<MangaClass> = listOf()
) : BaseSearchResponse()
