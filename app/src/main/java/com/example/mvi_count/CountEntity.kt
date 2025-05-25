package com.example.mvi_count

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "count_table")
data class CountEntity(
    @PrimaryKey val id: Int = 0,
    val count: Int
)
