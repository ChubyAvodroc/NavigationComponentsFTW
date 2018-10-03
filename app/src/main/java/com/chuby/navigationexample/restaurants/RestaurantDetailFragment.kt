package com.chuby.navigationexample.restaurants

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chuby.navigationexample.R
import com.chuby.navigationexample.data.Restaurant
import com.chuby.navigationexample.data.RestaurantRepository
import com.chuby.navigationexample.data.RestaurantRepositoryImpl
import kotlinx.android.synthetic.main.fragment_restaurant_detail.*

class RestaurantDetailFragment : Fragment() {

    private var restaurant: Restaurant? = null
    private lateinit var adapter: ReviewsAdapter
    private val repository: RestaurantRepository by lazy {
        RestaurantRepositoryImpl.getInstance(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val restaurantId = RestaurantDetailFragmentArgs.fromBundle(arguments).restaurantId
        restaurant = repository.getRestaurantById(restaurantId)
        adapter = ReviewsAdapter { review, view ->
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_restaurant_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvRestaurantReviews.layoutManager = LinearLayoutManager(requireContext())
        rvRestaurantReviews.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        restaurant?.let {
            tvRestaurantDescription.text = it.name
            adapter.updateItems(it.reviews)
        }
    }
}