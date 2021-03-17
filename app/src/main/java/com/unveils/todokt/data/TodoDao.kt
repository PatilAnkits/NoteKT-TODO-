package com.unveils.todokt.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.unveils.todokt.model.Todo

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTodo (todo: Todo)

    @Query("SELECT * FROM todo_table Order By id Asc")
    fun readAllData(): LiveData<List<Todo>>
}