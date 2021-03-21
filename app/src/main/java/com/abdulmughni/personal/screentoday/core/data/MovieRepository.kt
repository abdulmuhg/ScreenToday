package com.abdulmughni.personal.screentoday.core.data

import com.abdulmughni.personal.screentoday.core.data.source.local.LocalDataSource
import com.abdulmughni.personal.screentoday.core.data.source.remote.RemoteDataSource
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.core.domain.model.MovieReview
import com.abdulmughni.personal.screentoday.core.domain.repository.IMovieRepository
import com.abdulmughni.personal.screentoday.core.utils.AppExecutors
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMovieRepository {
    override fun getPopularMovies(): Flow<Responses<List<Movie>>> {
        TODO("Not yet implemented")
    }

    override fun getTopRatedMovies(): Flow<Responses<List<Movie>>> {
        TODO("Not yet implemented")
    }

    override fun getNowPlayingMovies(): Flow<Responses<List<Movie>>> {
        TODO("Not yet implemented")
    }

    override fun getMovieDetails(): Flow<Responses<Movie>> {
        TODO("Not yet implemented")
    }

    override fun getListOfReview(): Flow<Responses<List<MovieReview>>> {
        TODO("Not yet implemented")
    }
}