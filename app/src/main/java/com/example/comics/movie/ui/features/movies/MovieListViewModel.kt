package com.example.comics.movie.ui.features.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comics.movie.core.common.Result
import com.example.comics.movie.domain.model.Movie
import com.example.comics.movie.domain.usecase.GetTrendingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getTrendingMovies: GetTrendingMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<Result<List<Movie>>>(Result.Loading)
    val uiState: StateFlow<Result<List<Movie>>> = _uiState

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            getTrendingMovies().collect { result ->
                _uiState.value = result
            }
        }
    }
}

data class MovieListUiState(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val error: String? = null,
    val errorSnackbar: String? = null
)