package com.unveils.todokt.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "todo_table")
data class Todo (
    @PrimaryKey(autoGenerate = true )
    val id: Int,
    val title: String,
    val descp: String
): Parcelable