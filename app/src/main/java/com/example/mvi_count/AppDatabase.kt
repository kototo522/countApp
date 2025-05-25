package com.example.mvi_count

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CountEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countDao(): CountDao
}

