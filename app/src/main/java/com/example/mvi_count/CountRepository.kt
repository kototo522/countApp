package com.example.mvi_count

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountRepository(private val db: AppDatabase) {
    private val countDao = db.countDao()

    suspend fun getCount(): Int = withContext(Dispatchers.IO) {
        countDao.getCount()?.count ?: 0
    }

    suspend fun saveCount(count: Int) = withContext(Dispatchers.IO) {
        countDao.insertCount(CountEntity(id = 0, count = count))
    }
}

