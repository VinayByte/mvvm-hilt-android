package com.vinaybyte.mvvmandroid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinaybyte.mvvmandroid.data.Resource
import com.vinaybyte.mvvmandroid.data.datasource.UiState
import com.vinaybyte.mvvmandroid.data.datasource.repository.Repository
import com.vinaybyte.mvvmandroid.data.model.MovieItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @Author: Vinay
 * @Date: 25-12-2023
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _movies: MutableStateFlow<UiState<MutableList<MovieItem>>> =
        MutableStateFlow(UiState.loading())
    val movies: StateFlow<UiState<MutableList<MovieItem>>> = _movies

    fun getHomeData() {
        viewModelScope.launch {
            repository.loadHomeData()
                .map { result ->
                    when (result) {
                        is Resource.Success -> {
                            Resource.Success(result.data.results)
                        }

                        is Resource.Error -> {
                            Resource.Error(result.message)
                        }
                    }
                }
                .map { resource -> UiState.fromResource(resource) }
                .collect { state -> _movies.value = state }
        }
    }
}