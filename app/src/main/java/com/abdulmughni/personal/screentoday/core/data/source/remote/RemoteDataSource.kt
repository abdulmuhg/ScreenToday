package com.abdulmughni.personal.screentoday.core.data.source.remote

import android.util.Log
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MoviePopularEntity
import com.abdulmughni.personal.screentoday.core.data.source.remote.network.ApiResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.network.ApiService
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getMoviePopular(): Flow<ApiResponse<PopularMoviesResponse>> {
        return flow {
            try {
                val response = apiService.getMoviePopular()
                emit(ApiResponse.Success(response))
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
    suspend fun getMovieTopRated(): Flow<ApiResponse<TopRatedMoviesResponse>> {
        return flow {
            try {
                val response = apiService.getMovieTopRated()
                emit(ApiResponse.Success(response))
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
    suspend fun getMovieNowPlaying(): Flow<ApiResponse<NowPlayingMoviesResponse>> {
        return flow {
            try {
                val response = apiService.getMovieNowPlaying()
                emit(ApiResponse.Success(response))
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
    suspend fun getReviews(id: Int): Flow<ApiResponse<ListReviewMoviesResponse>> {
        return flow {
            try {
                val response = apiService.getMovieReviews(movie_id = id)
                emit(ApiResponse.Success(response))
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}