package com.chuby.navigationexample.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurant(
        val id: Int,
        val name: String,
        val rate: Double,
        val disclaimer: String,
        var image: Image? = null,
        var location: Location? = null,
        var reviews: MutableList<Review> = mutableListOf()
) : Parcelable

@Parcelize
data class Image(
        val url: String,
        val width: Int,
        val height: Int
) : Parcelable

@Parcelize
data class Location(
        val latitude: Double,
        val longitude: Double
) : Parcelable

@Parcelize
data class Review(
        val id: Int,
        val reviewer: String,
        val description: String,
        val rate: Double
) : Parcelable