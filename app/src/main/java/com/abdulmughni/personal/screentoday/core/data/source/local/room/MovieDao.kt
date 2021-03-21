package com.abdulmughni.personal.screentoday.core.data.source.local.room

import androidx.room.*
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieReviewEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies WHERE type = 0")
    fun getPopularMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies WHERE type = 1")
    fun getTopRatedMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies WHERE type = 2")
    fun getNowPlayingMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movies_review")
    fun getListMovieReview(): Flow<List<MovieReviewEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovie(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertReviewMovie(movie: List<MovieReviewEntity>)

    @Update
    fun updateMovie(moviePopular: MovieEntity)

    @Query("SELECT * FROM movies where isFavorite = 1")
    fun getFavoriteMovie(): Flow<List<MovieEntity>>

}