package com.unveils.todokt.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.unveils.todokt.model.Todo

@Database(entities = [Todo::class], version = 1 , exportSchema = false)
abstract class TodoDatabase: RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object{
        @Volatile
        private var INSTANCE: TodoDatabase ? =  null

        fun getDatabase(context: Context): TodoDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "todo_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}