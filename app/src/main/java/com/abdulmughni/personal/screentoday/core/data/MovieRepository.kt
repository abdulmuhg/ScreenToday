package com.abdulmughni.personal.screentoday.core.data

import com.abdulmughni.personal.screentoday.core.data.source.local.LocalDataSource
import com.abdulmughni.personal.screentoday.core.data.source.remote.RemoteDataSource
import com.abdulmughni.personal.screentoday.core.data.source.remote.network.ApiResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.ListReviewMoviesResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.NowPlayingMoviesResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.PopularMoviesResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.TopRatedMoviesResponse
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.core.domain.model.MovieReview
import com.abdulmughni.personal.screentoday.core.domain.repository.IMovieRepository
import com.abdulmughni.personal.screentoday.core.utils.AppExecutors
import com.abdulmughni.personal.screentoday.core.utils.MovieMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMovieRepository {
    override fun getPopularMovies(): Flow<Responses<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, PopularMoviesResponse>(appExecutors) {
            override fun loadFromDB(): Flow<List<Movie>> =
                localDataSource.getMoviePopular().map {
                    MovieMapper.mapEntitiesToDomain(it)
                }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<PopularMoviesResponse>> =
                remoteDataSource.getMoviePopular()

            override suspend fun saveCallResult(data: PopularMoviesResponse) {
                val movieList = MovieMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }

        }.asFlow()

    override fun getTopRatedMovies(): Flow<Responses<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, TopRatedMoviesResponse>(appExecutors) {
            override fun loadFromDB(): Flow<List<Movie>> =
                localDataSource.getMovieTopRated().map {
                    MovieMapper.mapEntitiesToDomain(it)
                }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<TopRatedMoviesResponse>> =
               remoteDataSource.getMovieTopRated()


            override suspend fun saveCallResult(data: TopRatedMoviesResponse) {
                val movieList = MovieMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }
        }.asFlow()

    override fun getNowPlayingMovies(): Flow<Responses<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, NowPlayingMoviesResponse>(appExecutors) {
            override fun loadFromDB(): Flow<List<Movie>> =
                localDataSource.getMovieNowPlaying().map {
                    MovieMapper.mapEntitiesToDomain(it)
                }

            override fun shouldFetch(data: List<Movie>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<NowPlayingMoviesResponse>> =
                remoteDataSource.getMovieNowPlaying()

            override suspend fun saveCallResult(data: NowPlayingMoviesResponse) {
                val movieList = MovieMapper.mapResponsesToEntities(data)
                localDataSource.insertMovie(movieList)
            }


        }.asFlow()

    override fun setMovieFavorite(movie: Movie, isFavorite: Boolean) {
        val movieEntity = MovieMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovie(movieEntity, isFavorite)
        }
    }

    override fun getMovieFavorite(): Flow<List<Movie>> = localDataSource.getMovieFavorite().map { MovieMapper.mapEntitiesToDomain(it) }

    override fun getListOfReview(id: Int): Flow<Responses<List<MovieReview>>> =
        object : NetworkBoundResource<List<MovieReview>, ListReviewMoviesResponse>(appExecutors) {
            override fun loadFromDB(): Flow<List<MovieReview>> =
                localDataSource.getMovieReviewList().map {
                    MovieMapper.mapEntitiesToDomainR(it)
                }

            override fun shouldFetch(data: List<MovieReview>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<ListReviewMoviesResponse>> =
                remoteDataSource.getReviews(id)

            override suspend fun saveCallResult(data: ListReviewMoviesResponse) {
                val reviewList = MovieMapper.mapResponsesToEntities(data)
                localDataSource.insertListReview(reviewList)
            }

        }.asFlow()

    override fun getMovieDetails(): Flow<Responses<Movie>> {
        TODO("Not yet implemented")
    }
}