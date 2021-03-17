package com.unveils.todokt.repository

import androidx.lifecycle.LiveData
import com.unveils.todokt.data.TodoDao
import com.unveils.todokt.model.Todo

class TodoRepository(private val todoDao: TodoDao) {
    val readAllData : LiveData<List<Todo>> =  todoDao.readAllData()

    suspend fun addTodo(todo: Todo){
        todoDao.addTodo(todo)
    }
}