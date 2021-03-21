package com.abdulmughni.personal.screentoday.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Dates(

    @field:SerializedName("maximum")
    val maximum: String? = null,

    @field:SerializedName("minimum")
    val minimum: String? = null
)