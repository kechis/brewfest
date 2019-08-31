package org.kechis.brewfest.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.kechis.brewfest.data.interfaces.BrewDataSource
import org.kechis.brewfest.model.Brew
import java.io.IOException


class BrewsViewModel(private val repository: BrewDataSource, private val context: Context) {

    var brews = ObservableArrayList<Brew>()
    var loadingVisibility = ObservableBoolean(false)
    //Handling the second User Story - ReverseSorting
    var vikingMode = ObservableBoolean(false)
    private lateinit var items : List<Brew>
    private val mPREFS = "myPreferences"
    //Handling the third User Story - Offline
    private lateinit var prefs: SharedPreferences


    fun getFoods(food: String) {
        prefs = context.getSharedPreferences(mPREFS, Context.MODE_PRIVATE)
        val gson = Gson()

        if(prefs.contains(food)) {
            val json = prefs.getString(food, "")
            items = gson.fromJson<List<Brew>>(json, object : TypeToken<List<Brew>>() {

            }.type)
            setBrews()

        }else {

            loadingVisibility.set(true)
            repository.getBrews(food, { items ->
                this.items = items
                setBrews()
                if (items.isNotEmpty()) {
                    val editor = prefs.edit()
                    try {
                        val json = gson.toJson(items)
                        editor.putString(food, json)
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                    editor.apply()
                }
                loadingVisibility.set(false)
            }, {
                loadingVisibility.set(false)
            })
        }

    }

    fun setBrews(){
        if (!::items.isInitialized) return
        brews.clear()
        val mBrews = if (vikingMode.get()) items.sortedByDescending { it.abv } else items.sortedBy { it.abv }
        brews.addAll(mBrews)
    }

}
