package com.example.mvi_count.di

import android.content.Context
import androidx.room.Room
import com.example.mvi_count.AppDatabase
import com.example.mvi_count.CountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "count_database"
        ).build()

    @Provides
    @Singleton
    fun provideCountRepository(db: AppDatabase): CountRepository =
        CountRepository(db)
}
