package com.example.recyclerviewlivedata
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val itemList: List<ListItem>, private val listener : OnItemClickListener)
    : RecyclerView.Adapter<ListAdapter.ListItemViewHolder>(){

    inner class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        init{
            itemView.setOnClickListener(this)
        }

        val clickTextView : TextView = itemView.findViewById(R.id.click_text_view)

        override fun onClick(v: View?) {
            listener.onListItemClicked(bindingAdapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val viewToDisplay = itemList[position]
        holder.clickTextView.text = "Clicked " + viewToDisplay.clicks.toString() + " times"
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    interface OnItemClickListener{
        fun onListItemClicked(position: Int)
    }

}

