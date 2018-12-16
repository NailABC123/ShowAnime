package com.nail.showanime.models

import com.google.gson.annotations.SerializedName

data class CharacterSearchResponse(
    @SerializedName("results")
    var results: List<Character> = listOf()
) : BaseSearchResponse()
