package com.chuby.navigationexample.restaurants

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chuby.navigationexample.R
import com.chuby.navigationexample.data.Restaurant
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestaurantsAdapter(
        private val onItemClickListener: (Restaurant) -> Unit = {}
) : RecyclerView.Adapter<RestaurantsAdapter.RestaurantViewHolder>() {

    private val items: MutableList<Restaurant> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return RestaurantViewHolder(itemView, onItemClickListener)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = items[position]
        holder.bindTo(restaurant)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = R.layout.item_restaurant

    fun updateItems(newItems: List<Restaurant>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class RestaurantViewHolder(
            itemView: View,
            private val onItemClickListener: (Restaurant) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindTo(item: Restaurant) {
            with(item) {
                itemView.tvRestaurantName.text = name
                itemView.tvRestaurantRate.text = rate.toString()
                itemView.tvRestaurantDisclaimer.text = disclaimer
                itemView.setOnClickListener {
                    onItemClickListener(this)
                }
            }
        }
    }
}

