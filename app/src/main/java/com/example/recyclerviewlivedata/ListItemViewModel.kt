package com.example.recyclerviewlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListItemViewModel : ViewModel() {

    private var _mutableLiveData : MutableLiveData<List<ListItem>> = MutableLiveData(mutableListOf())
    val mutableLiveData : LiveData<List<ListItem>>
        get() = _mutableLiveData

    private var itemList : ArrayList<ListItem> = ArrayList()

    init {
        itemList.add(ListItem())
        itemList.add(ListItem())
        itemList.add(ListItem())
        itemList.add(ListItem())
        itemList.add(ListItem())
        itemList.add(ListItem())
        itemList.add(ListItem())
        itemList.add(ListItem())
        itemList.add(ListItem())
        itemList.add(ListItem())
        itemList.add(ListItem())
        itemList.add(ListItem())
        itemList.add(ListItem())

        _mutableLiveData.value = itemList
    }

    fun getData() : List<ListItem>{
        return _mutableLiveData.value!!
    }

    fun incrementClicks(position: Int){
        val item = _mutableLiveData.value?.get(position)
        item!!.clicks ++
        _mutableLiveData.value = itemList
    }

}


