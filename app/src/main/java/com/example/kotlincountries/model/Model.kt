package com.example.kotlincountries.model

import android.icu.util.Currency
import com.google.gson.annotations.SerializedName
import org.intellij.lang.annotations.Language
import java.net.URL

data class Country(
    @SerializedName("name")
    val countryName : String?,
    @SerializedName("region")
    val countryRegion : String?,
    @SerializedName("capital")
    val countryCapital: String?,
    @SerializedName("currency")
    val countryCurrency: String?,
    @SerializedName("language")
    val countryLanguage: String?,
    @SerializedName("flag")
    val imageURL: String?)