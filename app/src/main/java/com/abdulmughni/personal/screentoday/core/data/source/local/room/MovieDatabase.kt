package com.abdulmughni.personal.screentoday.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieNowPlayingEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MoviePopularEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieReviewEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieTopRatedEntity

@Database(entities = [
    MoviePopularEntity::class,
    MovieReviewEntity::class,
    MovieNowPlayingEntity::class,
    MovieTopRatedEntity::class], version = 1, exportSchema = false)

abstract class MovieDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}