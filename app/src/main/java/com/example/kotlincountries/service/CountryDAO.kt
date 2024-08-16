package com.example.kotlincountries.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlincountries.model.Country

@Dao
interface CountryDAO {

    //Data Access Object

    @Insert
    suspend fun insertAll(vararg countries : Country) : List<Long>

    //Insert -> Inser Into
    //Suspend -> coroutine, pause & resume
    //vararg -> multiple country object

    @Query("Select * from country")
    suspend fun getAllCountries() : List<Country>

    @Query("Select * from country WHERE uuid = :countryId")
    suspend fun getCountry(countryId : Int) : Country

    @Query("Delete from country")
    suspend fun deleteAllCountries()



}