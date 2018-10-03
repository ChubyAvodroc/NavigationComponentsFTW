package com.chuby.navigationexample.reviews

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chuby.navigationexample.R
import com.chuby.navigationexample.data.Review
import kotlinx.android.synthetic.main.fragment_review_detail.*

class ReviewDetailFragment : Fragment() {

    private var review: Review? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        review = ReviewDetailFragmentArgs.fromBundle(arguments).review
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_review_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvReviewObject.text = review?.toString() ?: "There is no object"
    }

}