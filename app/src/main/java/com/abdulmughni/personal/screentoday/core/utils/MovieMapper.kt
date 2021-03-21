package com.abdulmughni.personal.screentoday.core.utils

import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MoviePopularEntity
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.NowPlayingMoviesResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.PopularMoviesResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.ResultsItem
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.TopRatedMoviesResponse
import com.abdulmughni.personal.screentoday.core.domain.model.Movie

object MovieMapper {

    fun mapResponsesToEntities(input: PopularMoviesResponse): List<MovieEntity>{
        val data = ArrayList<MovieEntity>()
        input.results.map {
            val movie = MovieEntity(
                id = it.id,
                title = it.title,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage,
                posterPath = it.posterPath,
                popularity = it.popularity,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                adult = it.adult,
                releaseDate = it.releaseDate,
                originalTitle = it.originalTitle,
                backdropPath = it.backdropPath,
                genre = ""
            )
            data.add(movie)
        }
        return data
    }

    fun mapResponsesToEntities(input: TopRatedMoviesResponse): List<MovieEntity>{
        val data = ArrayList<MovieEntity>()
        input.results.map {
            val movie = MovieEntity(
                id = it.id,
                title = it.title,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage,
                posterPath = it.posterPath,
                popularity = it.popularity,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                adult = it.adult,
                releaseDate = it.releaseDate,
                originalTitle = it.originalTitle,
                backdropPath = it.backdropPath,
                genre = ""
            )
            data.add(movie)
        }
        return data
    }

    fun mapResponsesToEntities(input: NowPlayingMoviesResponse): List<MovieEntity>{
        val data = ArrayList<MovieEntity>()
        input.results.map {
            val movie = MovieEntity(
                id = it.id,
                title = it.title,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage,
                posterPath = it.posterPath,
                popularity = it.popularity,
                overview = it.overview,
                originalLanguage = it.originalLanguage,
                adult = it.adult,
                releaseDate = it.releaseDate,
                originalTitle = it.originalTitle,
                backdropPath = it.backdropPath,
                genre = ""
            )
            data.add(movie)
        }
        return data
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                genre = it.genre,
                backdropPath = it.backdropPath,
                originalTitle = it.originalTitle,
                releaseDate = it.releaseDate,
                adult = it.adult,
                originalLanguage = it.originalLanguage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                title = it.title,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(it: Movie) = MovieEntity(
        id = it.id,
        genre = it.genre,
        backdropPath = it.backdropPath,
        originalTitle = it.originalTitle,
        releaseDate = it.releaseDate,
        adult = it.adult,
        originalLanguage = it.originalLanguage,
        overview = it.overview,
        popularity = it.popularity,
        posterPath = it.posterPath,
        voteAverage = it.voteAverage,
        voteCount = it.voteCount,
        title = it.title
    )
}