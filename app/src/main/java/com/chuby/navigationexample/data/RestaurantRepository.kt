package com.chuby.navigationexample.data

interface RestaurantRepository {

    fun getRestaurants(): List<Restaurant>

    fun getRestaurantById(restaurantId: Int): Restaurant?

    fun getReviewsByRestaurantId(restaurantId: Int): List<Review>

    fun getReviewById(reviewId: Int): Review?
}