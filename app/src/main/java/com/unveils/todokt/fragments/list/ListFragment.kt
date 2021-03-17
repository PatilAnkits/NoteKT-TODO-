package com.unveils.todokt.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.unveils.todokt.R
import com.unveils.todokt.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var mTodoViewModel: TodoViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list, container, false)

        // RecyclerView
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)

        // ToddViewModel

        mTodoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)
        mTodoViewModel.readAllData.observe(viewLifecycleOwner, Observer{ todo  ->
            adapter.setData(todo)
        })


        view.floatingActionButton.setOnClickListener { findNavController().navigate(R.id.action_listFragment_to_addFragment) }
        return  view
    }

}