package com.unveils.todokt.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unveils.todokt.R
import com.unveils.todokt.model.Todo
import kotlinx.android.synthetic.main.custom_todo_row.view.*
import java.util.*


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var todoList = emptyList<Todo>()
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder{
        return  MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_todo_row,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return  todoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = todoList[position]

        holder.itemView.id_tw.text = currentItem.id.toString()
        holder.itemView.title_tw.text = currentItem.title
        holder.itemView.desc_tw.text = currentItem.descp

        val androidColors: IntArray = holder.itemView.resources.getIntArray(R.array.androidcolors)
        val randomAndroidColor = androidColors[Random().nextInt(androidColors.size)]
        holder.itemView.title_tw.setTextColor(randomAndroidColor)

    }

    fun setData(todo: List<Todo>){
        this.todoList = todo
        notifyDataSetChanged()

    }
}