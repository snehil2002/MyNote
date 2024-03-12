package com.example.mynote.di

import android.content.Context
import androidx.room.Room
import com.example.mynote.data.Dao
import com.example.mynote.data.Roomdatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object Appmodule {

    @Provides
    @Singleton
    fun providedao(roomdatabase:Roomdatabase):Dao{
        return roomdatabase.notedao()}

    @Singleton
    @Provides
    fun providedatabase(@ApplicationContext context:Context):Roomdatabase{
     return Room.databaseBuilder(
          context,
          Roomdatabase::class.java,
          name = "database1"
      ).fallbackToDestructiveMigration().build()
    }


}