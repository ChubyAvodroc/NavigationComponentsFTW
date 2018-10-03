package com.chuby.navigationexample.bookin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.chuby.navigationexample.R
import kotlinx.android.synthetic.main.fragment_bookin.*

class BookInFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_bookin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bBook.setOnClickListener(Navigation
                .createNavigateOnClickListener(R.id.action_bookInFragment_to_reviewDetailFragment))
    }
}