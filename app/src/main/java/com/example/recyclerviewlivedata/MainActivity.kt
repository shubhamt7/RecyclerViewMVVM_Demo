package com.example.recyclerviewlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ListAdapter.OnItemClickListener{

    private val viewModel : ListItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView:RecyclerView = findViewById(R.id.recycler_view)

        viewModel.mutableLiveData.observe(this, {
            recyclerView.adapter = ListAdapter(viewModel.getData(),this)
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListAdapter(viewModel.getData(), this)

    }

    override fun onListItemClicked(position: Int) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
        viewModel.incrementClicks(position)
    }
}