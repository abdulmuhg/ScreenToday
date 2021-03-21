package com.abdulmughni.personal.screentoday.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    var type: Int,
    var posterPath: String? = null,
    var adult: Boolean = false,
    var overview: String,
    var releaseDate: String,
    var title: String,
    var genre: String,
    var originalTitle: String,
    var originalLanguage: String,
    var backdropPath: String?= null,
    var popularity: Double,
    var voteCount: Int,
    var voteAverage: Double,
    var isFavorite: Boolean
) : Parcelable