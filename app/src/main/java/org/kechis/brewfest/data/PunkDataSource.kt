package org.kechis.brewfest.data

import org.kechis.brewfest.data.interfaces.BrewDataSource
import org.kechis.brewfest.data.interfaces.PunkApi
import org.kechis.brewfest.model.Brew
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PunkDataSource(private val punkApi: PunkApi) : BrewDataSource {
    override fun getBrews(food: String, success: (List<Brew>) -> Unit, failure: () -> Unit) {
        val call = punkApi.getBrews(food)
        call.enqueue(object : Callback<List<Brew>> {

            override fun onResponse(call: Call<List<Brew>>, response: Response<List<Brew>>) {
                if (response.isSuccessful) {
                    val brews = response.body()!!

                    success(brews.sortedBy { it.abv })
                } else {
                    failure()
                }
            }

            override fun onFailure(call: Call<List<Brew>>, t: Throwable?) {
                failure()
            }
        })
    }


}