package com.unveils.todokt.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.unveils.todokt.R
import com.unveils.todokt.model.Todo
import com.unveils.todokt.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mTodoViewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mTodoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
       val title = title_et.text.toString()
        val description = desc_et.text.toString()

        if (inputCheck(title,description)){
            val todo = Todo(0,title,description)

            mTodoViewModel.addTodo(todo)
            Toast.makeText(
                requireContext(),"Your Todo is added successfully", Toast.LENGTH_SHORT
            ).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
    }

    private fun inputCheck(title: String, description: String):Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(description))
    }
}