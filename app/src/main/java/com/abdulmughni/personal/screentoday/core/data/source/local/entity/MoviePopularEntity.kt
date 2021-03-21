package com.abdulmughni.personal.screentoday.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movies_popular")
data class MoviePopularEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    var posterPath: String? = null,
    var adult: Boolean,
    var overview: String,
    var releaseDate: String,
    var title: String,
    var genre: String,
    var originalTitle: String,
    var originalLanguage: String,
    var backdropPath: String? = null,
    var popularity: Double,
    var voteCount: Int,
    var voteAverage: Double,
    var isFavorite: Boolean = false
) : Parcelable