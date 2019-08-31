package org.kechis.brewfest.data.interfaces

import org.kechis.brewfest.model.Brew
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PunkApi {
    @GET("beers")
    fun getBrews(
        @Query("food") food: String
    ): Call<List<Brew>>

}