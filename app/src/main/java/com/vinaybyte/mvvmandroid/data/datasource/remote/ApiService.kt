package com.vinaybyte.mvvmandroid.data.datasource.remote

import com.vinaybyte.mvvmandroid.data.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * @Author: Vinay
 * @Date: 25-12-2023
 */
interface ApiService {
    @GET("/JsonSandbox/apis/movies.json")
    suspend fun getMovies(): Response<MoviesResponse>
}