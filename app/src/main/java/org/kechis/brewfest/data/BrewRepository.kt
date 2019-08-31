package org.kechis.brewfest.data

import org.kechis.brewfest.data.interfaces.BrewDataSource
import org.kechis.brewfest.model.Brew

class BrewRepository(private val brewDataSource: BrewDataSource) :
    BrewDataSource {

    override fun getBrews(food: String, success: (List<Brew>) -> Unit, failure: () -> Unit) {
        brewDataSource.getBrews(food, success, failure)
    }

}