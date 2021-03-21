package com.abdulmughni.personal.screentoday.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movies_top_rated")
data class MovieTopRatedEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,

    var posterPath: String? = null,
    var adult: Boolean = false,
    var overview: String? = null,
    var releaseDate: String? = null,
    var title: String? = null,
    var genre: String? = null,
    var originalTitle: String? = null,
    var originalLanguage: String? = null,
    var backdropPath: String? = null,
    var popularity: Int? = null,
    var voteCount: Int? = null,
    var voteAverage: Int? = null
) : Parcelable