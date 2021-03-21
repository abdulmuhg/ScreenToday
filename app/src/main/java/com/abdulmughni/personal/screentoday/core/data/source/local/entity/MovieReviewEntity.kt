package com.abdulmughni.personal.screentoday.core.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movies_review")
data class MovieReviewEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,

    var author: String,
    var content: String,
    var createdAt: String,
    val authorId: String,
    var updateAt: String,
    var url: String
) : Parcelable