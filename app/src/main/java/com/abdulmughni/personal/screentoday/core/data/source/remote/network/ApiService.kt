package com.abdulmughni.personal.screentoday.core.data.source.remote.network

import com.abdulmughni.personal.screentoday.BuildConfig
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.ListReviewMoviesResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.NowPlayingMoviesResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.PopularMoviesResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.TopRatedMoviesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    companion object {
        private const val API_KEY: String = BuildConfig.API_KEY
    }

    @GET("movie/popular")
    suspend fun getMoviePopular(
        @Query("api_key") api_key: String = API_KEY
    ): PopularMoviesResponse

    @GET("movie/now_playing")
    suspend fun getMovieNowPlaying(
        @Query("api_key") api_key: String = API_KEY
    ): NowPlayingMoviesResponse

    @GET("movie/top_rated")
    suspend fun getMovieTopRated(
        @Query("api_key") api_key: String = API_KEY
    ): TopRatedMoviesResponse

    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieReviews(
        @Query("api_key") api_key: String = API_KEY,
        @Path("movie_id") movie_id: Int
    ): ListReviewMoviesResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Query("api_key") api_key: String = API_KEY,
        @Path("movie_id") movie_id: Int
    )
}