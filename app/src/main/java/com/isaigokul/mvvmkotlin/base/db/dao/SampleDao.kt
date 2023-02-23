package com.isaigokul.mvvmkotlin.base.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.isaigokul.mvvmkotlin.base.db.entity.SampleEntity

@Dao
interface SampleDao {

    @Query("SELECT * FROM SampleEntity")
    fun getAllTasksList(): List<SampleEntity?>?

    @Query(value = "DELETE FROM SampleEntity")
    fun truncateTheList()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDataIntoTaskList(task: SampleEntity?)

    @Query("DELETE FROM SampleEntity ")
    fun deleteTaskFromId()

}