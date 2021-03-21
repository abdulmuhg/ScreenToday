package com.abdulmughni.personal.screentoday.core.utils

import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieEntity
import com.abdulmughni.personal.screentoday.core.data.source.local.entity.MovieReviewEntity
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.ListReviewMoviesResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.NowPlayingMoviesResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.PopularMoviesResponse
import com.abdulmughni.personal.screentoday.core.data.source.remote.response.TopRatedMoviesResponse
import com.abdulmughni.personal.screentoday.core.domain.model.Movie
import com.abdulmughni.personal.screentoday.core.domain.model.MovieReview

object MovieMapper {

    fun mapResponsesToEntities(input: PopularMoviesResponse): List<MovieEntity>{
        val data = ArrayList<MovieEntity>()
        input.results.map {
            val movie = MovieEntity(
                id = it.id,
                type = 0,
                posterPath = it.posterPath,
                adult = it.adult,
                overview = it.overview,
                releaseDate = it.releaseDate,
                title = it.title,
                genre = "",
                originalTitle = it.originalTitle,
                originalLanguage = it.originalLanguage,
                backdropPath = it.backdropPath,
                popularity = it.popularity,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage
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
                type = 1,
                posterPath = it.posterPath,
                adult = it.adult,
                overview = it.overview,
                releaseDate = it.releaseDate,
                title = it.title,
                genre = "",
                originalTitle = it.originalTitle,
                originalLanguage = it.originalLanguage,
                backdropPath = it.backdropPath,
                popularity = it.popularity,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage
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
                type = 2,
                posterPath = it.posterPath,
                adult = it.adult,
                overview = it.overview,
                releaseDate = it.releaseDate,
                title = it.title,
                genre = "",
                originalTitle = it.originalTitle,
                originalLanguage = it.originalLanguage,
                backdropPath = it.backdropPath,
                popularity = it.popularity,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage
            )
            data.add(movie)
        }
        return data
    }

    fun mapResponsesToEntities(input: ListReviewMoviesResponse): List<MovieReviewEntity>{
        val data = ArrayList<MovieReviewEntity>()
        input.results.map {
            val movie = MovieReviewEntity(
                id = it.id,
                url = it.url,
                content = it.content,
                author = it.author,
                authorId = it.id,
                createdAt = it.createdAt,
                updateAt = it.updatedAt
            )
            data.add(movie)
        }
        return data
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                type = it.type,
                posterPath = it.posterPath,
                adult = it.adult,
                overview = it.overview,
                releaseDate = it.releaseDate,
                title = it.title,
                genre = it.genre,
                originalTitle = it.originalTitle,
                originalLanguage = it.originalLanguage,
                backdropPath = it.backdropPath,
                popularity = it.popularity,
                voteCount = it.voteCount,
                voteAverage = it.voteAverage,
                isFavorite = it.isFavorite
            )
        }

    fun mapEntitiesToDomainR(input: List<MovieReviewEntity>): List<MovieReview> =
        input.map {
            MovieReview(
                id = it.id,
                createdAt = it.createdAt,
                updateAt = it.updateAt,
                authorId = it.authorId,
                author = it.author,
                content = it.content,
                url = it.url
            )
        }

    fun mapDomainToEntity(it: Movie) = MovieEntity(
        id = it.id,
        type = it.type,
        posterPath = it.posterPath,
        adult = it.adult,
        overview = it.overview,
        releaseDate = it.releaseDate,
        title = it.title,
        genre = it.genre,
        originalTitle = it.originalTitle,
        originalLanguage = it.originalLanguage,
        backdropPath = it.backdropPath,
        popularity = it.popularity,
        voteCount = it.voteCount,
        voteAverage = it.voteAverage
    )
}