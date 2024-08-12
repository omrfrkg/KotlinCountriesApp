package com.example.kotlincountries.model

import android.icu.util.Currency
import org.intellij.lang.annotations.Language
import java.net.URL

data class Country(
    val countryName : String?,
    val countryRegion : String?,
    val countryCapital: String?,
    val countryCurrency: String?,
    val countryLanguage: String?,
    val imageURL: String?)