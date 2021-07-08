package com.example.recyclerviewlivedata

class ListItem {

    private var _clicks : Int = 0
    var clicks : Int
        get() = _clicks
        set(value){
            _clicks = value
        }
}