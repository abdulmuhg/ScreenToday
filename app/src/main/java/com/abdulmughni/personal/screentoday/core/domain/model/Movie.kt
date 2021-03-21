package com.abdulmughni.personal.screentoday.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    var posterPath: String? = null,
    var adult: Boolean = false,
    var overview: String,
    var releaseDate: String,
    var title: String,
    var genre: String,
    var originalTitle: String,
    var originalLanguage: String,
    var backdropPath: String,
    var popularity: Int,
    var voteCount: Int,
    var voteAverage: Int
) : Parcelable