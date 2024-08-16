package com.example.kotlincountries.model

import android.icu.util.Currency
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.intellij.lang.annotations.Language
import java.net.URL

@Entity()
data class Country(

    @ColumnInfo("name")
    @SerializedName("name")
    val countryName : String?,
    @ColumnInfo("region")
    @SerializedName("region")
    val countryRegion : String?,
    @ColumnInfo("capital")
    @SerializedName("capital")
    val countryCapital: String?,
    @ColumnInfo("currency")
    @SerializedName("currency")
    val countryCurrency: String?,
    @ColumnInfo("language")
    @SerializedName("language")
    val countryLanguage: String?,
    @ColumnInfo("flag")
    @SerializedName("flag")
    val imageURL: String?){

    @PrimaryKey(autoGenerate = true)
    var uuid  : Int = 0
}