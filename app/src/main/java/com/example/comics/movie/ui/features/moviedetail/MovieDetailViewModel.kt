package com.example.comics.movie.ui.features.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.comics.movie.data.repository.MovieRepository
import com.example.comics.movie.domain.model.MovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.comics.movie.core.common.Result
import com.example.comics.movie.core.network.NetworkError
import com.example.comics.movie.domain.usecase.GetMovieDetailUseCase
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.xml.sax.ErrorHandler
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MovieDetailUiState())
    val uiState: StateFlow<MovieDetailUiState> = _uiState.asStateFlow()

    fun loadMovieDetail(movieId: Int) {
        viewModelScope.launch {
            getMovieDetailUseCase(movieId).collect { result ->
                when (result) {
                    is Result.Loading -> {
                        _uiState.update { it.copy(isLoading = true, error = null) }
                    }
                    is Result.Success -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                movieDetail = result.data,
                                error = null
                            )
                        }
                    }
                    is Result.Error -> {
                        _uiState.update {
                            it.copy(isLoading = false, error = result.message)
                        }
                    }
                }
            }
        }
    }
}

data class MovieDetailUiState(
    val isLoading: Boolean = false,
    val movieDetail: MovieDetail? = null,
    val error: String? = null
)
