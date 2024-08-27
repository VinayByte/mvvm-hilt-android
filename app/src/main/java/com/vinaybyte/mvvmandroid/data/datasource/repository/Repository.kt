package com.vinaybyte.mvvmandroid.data.datasource.repository

import androidx.annotation.WorkerThread
import com.vinaybyte.mvvmandroid.data.Resource
import com.vinaybyte.mvvmandroid.data.datasource.remote.ApiService
import com.vinaybyte.mvvmandroid.data.model.MoviesResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

/**
 * @Author: Vinay
 * @Date: 25-12-2023
 */
class Repository @Inject constructor(
    private val service: ApiService
) {
    @WorkerThread
    fun loadHomeData(): Flow<Resource<MoviesResponse>> {
        return object : NetworkRepository<MoviesResponse>() {
            override suspend fun fetchFromNetwork(): Response<MoviesResponse> = service.getMovies()
        }.asFlow()
    }
}