package org.kechis.brewfest.utils

import androidx.databinding.Observable


fun <T: Observable> T.addOnPropertyChanged(callback: (T) -> Unit) =
    addOnPropertyChangedCallback(
        object: Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(
                observable: Observable?, i: Int) =
                callback(observable as T)
        })
