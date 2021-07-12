package com.example.recyclerviewlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ListAdapter.OnItemClickListener{

    private val viewModel : ListItemViewModel by viewModels()
    private lateinit var recyclerView:RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListAdapter(viewModel.getData(), this)


        //if entire mutablelivedata value changes
        viewModel.mutableLiveData.observe(this, {
            recyclerView.adapter = ListAdapter(viewModel.getData(), this)
        })
    }

    //if only a single item changes
    override fun onListItemClicked(position: Int) {
        val status = viewModel.incrementClicks(position)
        if(status)
            recyclerView.adapter?.notifyItemChanged(position)
        
    }
}