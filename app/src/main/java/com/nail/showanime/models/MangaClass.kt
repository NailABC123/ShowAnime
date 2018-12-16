package com.nail.showanime.models

import com.google.gson.annotations.SerializedName

data class MangaClass(
    @SerializedName("mal_id")
    var malId: Int = 0, // 77419
    @SerializedName("url")
    var url: String = "", // https://myanimelist.net/manga/77419/Kiruto
    @SerializedName("image_url")
    var imageUrl: String = "", // https://cdn.myanimelist.net/images/manga/2/134043.jpg?s=e836117eb56accffdfc1485d8eedf123
    @SerializedName("title")
    var title: String = "", // Kiruto
    @SerializedName("publishing")
    var publishing: Boolean = false, // false
    @SerializedName("synopsis")
    var synopsis: String = "",
    @SerializedName("type")
    var type: String = "", // Manga
    @SerializedName("chapters")
    var chapters: Int = 0, // 0
    @SerializedName("volumes")
    var volumes: Int = 0, // 4
    @SerializedName("score")
    var score: Int = 0, // 0
    @SerializedName("start_date")
    var startDate: String = "", // 2002-02-06T00:00:00+00:00
    @SerializedName("end_date")
    var endDate: String = "", // 2003-05-06T00:00:00+00:00
    @SerializedName("members")
    var members: Int = 0 // 54
)