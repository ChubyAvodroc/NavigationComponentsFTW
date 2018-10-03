package com.chuby.navigationexample.restaurants

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chuby.navigationexample.R
import com.chuby.navigationexample.data.Review
import kotlinx.android.synthetic.main.item_review.view.*

class ReviewsAdapter(
        private val onItemClickListener: ((Review, View) -> Unit)? = null
) : RecyclerView.Adapter<ReviewsAdapter.ReviewViewHolder>() {

    private val items: MutableList<Review> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ReviewViewHolder(itemView, onItemClickListener)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = items[position]
        holder.bindTo(review)
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = R.layout.item_review

    fun updateItems(newItems: List<Review>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class ReviewViewHolder(
            itemView: View,
            private val onItemClickListener: ((Review, View) -> Unit)?
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindTo(item: Review) {
            with(item) {
                itemView.tvReviewReviewer.text = reviewer
                itemView.tvReviewDescription.text = description
                itemView.tvReviewRate.text = "Rating: $rate"
                itemView.setOnClickListener {
                    onItemClickListener?.invoke(this, itemView)
                }
            }
        }
    }
}

