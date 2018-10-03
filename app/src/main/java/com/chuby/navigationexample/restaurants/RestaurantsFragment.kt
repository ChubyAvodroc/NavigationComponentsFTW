package com.chuby.navigationexample.restaurants

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import com.chuby.navigationexample.R
import android.view.ViewGroup
import com.chuby.navigationexample.data.RestaurantRepository
import com.chuby.navigationexample.data.RestaurantRepositoryImpl
import kotlinx.android.synthetic.main.fragment_restaurants.*

class RestaurantsFragment : Fragment() {

    private lateinit var adapter: RestaurantsAdapter
    private val repository: RestaurantRepository by lazy {
        RestaurantRepositoryImpl.getInstance(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = RestaurantsAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_restaurants, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvRestaurants.layoutManager = LinearLayoutManager(context)
        rvRestaurants.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.updateItems(repository.getRestaurants())
    }
}