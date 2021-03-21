package com.abdulmughni.personal.screentoday.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class PopularMoviesResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItem>,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)
