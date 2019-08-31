package org.kechis.brewfest.data.interfaces

import org.kechis.brewfest.model.Brew

interface  BrewDataSource {
    fun getBrews(food: String, success: (List<Brew>) -> Unit, failure: () -> Unit)
}