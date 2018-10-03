package com.chuby.navigationexample.data

data class Restaurant(
        val id: Int,
        val name: String,
        val rate: Double,
        val disclaimer: String,
        var image: Image? = null,
        var location: Location? = null,
        var reviews: MutableList<Review> = mutableListOf()
)

data class Image(
        val url: String,
        val width: Int,
        val height: Int
)

data class Location(
        val latitude: Double,
        val longitude: Double
)

data class Review(
        val id: Int,
        val reviewer: String,
        val description: String,
        val rate: Double
)