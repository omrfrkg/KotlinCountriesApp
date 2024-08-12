package com.example.kotlincountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincountries.model.Country

class FeedViewModel : ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val  countryLoading = MutableLiveData<Boolean>()

    fun refreshData() {
        val country  = Country("Turkey","Asia","Ankara","TRY","Turkish","ww.ss.com")
        val country2  = Country("France","Europe","Paris","EUR","French","ww.ss.com")
        val country3  = Country("Germany","Europe","Berlin","EUR","German","ww.ss.com")

        val countryList = arrayListOf<Country>(country,country2,country3)

        countries.value = countryList
        countryError.value = false
        countryLoading.value = false

    }
}