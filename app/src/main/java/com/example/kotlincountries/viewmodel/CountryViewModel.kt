package com.example.kotlincountries.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincountries.model.Country
import com.example.kotlincountries.service.CountryDatabase
import kotlinx.coroutines.launch
import java.util.UUID

class CountryViewModel(application: Application) : BaseViewModel(application){

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(uuid: Int){

        launch {
            val dao = CountryDatabase(getApplication()).countryDAO()
            val country = dao.getCountry(uuid)
            countryLiveData.value = country
        }

    }
}