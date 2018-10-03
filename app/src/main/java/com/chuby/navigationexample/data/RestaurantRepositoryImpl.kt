package com.chuby.navigationexample.data

import android.content.Context
import android.util.Log
import com.chuby.navigationexample.R
import com.google.gson.Gson
import java.util.concurrent.atomic.AtomicBoolean

class RestaurantRepositoryImpl private constructor(context: Context) : RestaurantRepository {

    private val TAG = "RestaurantRepository"
    private val restaurants: MutableList<Restaurant> = mutableListOf()

    companion object {

        private lateinit var INSTANCE: RestaurantRepository
        private val initialized = AtomicBoolean()

        fun getInstance(context: Context): RestaurantRepository {
            if (!initialized.getAndSet(true)) {
                INSTANCE = RestaurantRepositoryImpl(context)
            }

            return INSTANCE
        }
    }


    init {
        val json = context.resources.getString(R.string.restaurants_sample)
        restaurants.addAll(Gson().fromJson(json, Array<Restaurant>::class.java))

        Log.i(TAG, "Restaurants to show are: $restaurants")
    }

    override fun getRestaurants(): List<Restaurant> = restaurants

    override fun getRestaurantById(restaurantId: Int): Restaurant? = restaurants.find {
        it.id == restaurantId
    }

    override fun getReviewsByRestaurantId(restaurantId: Int): List<Review> {
        return getRestaurantById(restaurantId)?.reviews ?: mutableListOf()
    }

    override fun getReviewById(reviewId: Int): Review? =
            restaurants.flatMap { it.reviews }.find { it.id == reviewId }

}