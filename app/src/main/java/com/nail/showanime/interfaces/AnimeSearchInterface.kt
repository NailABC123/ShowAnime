package com.nail.showanime.interfaces

import com.nail.showanime.models.AnimeSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeSearchInterface {

    @GET("search/anime")
    fun searchAnime(@Query("q") searchQuery: String) : Call<AnimeSearchResponse>


}