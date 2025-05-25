package com.example.mvi_count

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface CountDao {
    @Query("SELECT * FROM count_table WHERE id = 0")
    suspend fun getCount(): CountEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCount(count: CountEntity)

    @Update
    suspend fun updateCount(count: CountEntity)
}
