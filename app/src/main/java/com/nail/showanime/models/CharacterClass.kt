package com.nail.showanime.models

import com.google.gson.annotations.SerializedName

data class CharacterClass(
    @SerializedName("mal_id")
    var malId: Int = 0, // 134344
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/character/134344/Smoking_Lightning
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/characters/8/294183.jpg?s=2abc6fe83b0151670935e0ab135332d7
    @SerializedName("name")
    var name: String = "", // Smoking Lightning
    @SerializedName("alternative_names")
    var alternativeNames: List<String> = listOf(),
    @SerializedName("anime")
    var anime: List<CharactersAppearances> = listOf(),
    @SerializedName("manga")
    var manga: List<CharactersAppearances> = listOf()
)