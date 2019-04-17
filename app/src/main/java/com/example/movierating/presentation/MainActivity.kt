package com.example.movierating.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.movierating.R
import com.example.movierating.presentation.list.TopRatedListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, TopRatedListFragment.newInstance(), TopRatedListFragment.TAG)
            .commit()
    }
}
