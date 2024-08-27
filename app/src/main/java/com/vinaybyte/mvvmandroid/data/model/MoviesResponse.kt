package com.vinaybyte.mvvmandroid.data.model

import com.google.gson.annotations.SerializedName

/**
 * @Author: Vinay
 * @Date: 25-12-2023
 */
data class MoviesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: MutableList<MovieItem>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)
