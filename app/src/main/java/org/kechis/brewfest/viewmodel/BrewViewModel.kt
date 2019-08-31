package org.kechis.brewfest.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import org.kechis.brewfest.model.Brew


class BrewViewModel(private val mBrew: Brew) : BaseObservable() {

    val abvString: String
    @Bindable
    get() = abv.toString() + "º"

    var id: Int?
        @Bindable
        get() = mBrew.id
        set(id) {
            mBrew.id = id!!
            //TODO REVIEW
//            notifyPropertyChanged(BR.id)
        }

    var name: String?
        @Bindable
        get() = mBrew.name
        set(name) {
            mBrew.name = name!!
//            notifyPropertyChanged(BR.name)
        }

    var description: String?
        @Bindable
        get() = mBrew.description
        set(description) {
            mBrew.description = description!!
//            notifyPropertyChanged(BR.description)
        }

    private var abv: Double?
        @Bindable
        get() = mBrew.abv
        set(id) {
            mBrew.abv = abv!!
//            notifyPropertyChanged(BR.abv)
        }

}