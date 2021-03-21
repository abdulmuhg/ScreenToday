package com.abdulmughni.personal.screentoday.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieReview(
    val id: Int,
    var author: String,
    var content: String,
    var createdAt: String,
    val authorId: String,
    var updateAt: String,
    var url: String
) : Parcelable