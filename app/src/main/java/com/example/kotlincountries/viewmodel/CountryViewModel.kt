package com.example.kotlincountries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincountries.model.Country

class CountryViewModel : ViewModel(){
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(){

        val country  = Country("Turkey","Asia","Ankara","TRY","Turkish","ww.ss.com")

        countryLiveData.value = country

    }
}