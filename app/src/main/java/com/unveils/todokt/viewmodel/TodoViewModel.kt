package com.unveils.todokt.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.unveils.todokt.data.TodoDatabase
import com.unveils.todokt.repository.TodoRepository
import com.unveils.todokt.model.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {

    val  readAllData: LiveData<List<Todo>>
    private val repository: TodoRepository

    init {
        val todoDao = TodoDatabase.getDatabase(application).todoDao()
        repository = TodoRepository(todoDao)
        readAllData = repository.readAllData
    }

    fun addTodo(todo: Todo){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.addTodo(todo)
        }
    }

}