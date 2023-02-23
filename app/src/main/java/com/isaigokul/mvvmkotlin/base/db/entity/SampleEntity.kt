package com.isaigokul.mvvmkotlin.base.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "SampleEntity", indices = [Index(value = ["taskId"], unique = true)])
class SampleEntity
    (
    @ColumnInfo(name = "taskTitle")
    var taskTitle: String? = null,
    @ColumnInfo(name = "date")
    var date: String? = null
) {
    @ColumnInfo(name = "taskId")
    @PrimaryKey(autoGenerate = true)
    var taskId = 0
}