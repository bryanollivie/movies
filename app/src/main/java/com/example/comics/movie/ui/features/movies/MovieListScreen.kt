package com.example.comics.movie.ui.features.movies

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.comics.movie.core.common.Result
import com.example.comics.movie.domain.model.Movie
import com.example.comics.movie.ui.navigation.Routes
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MovieListViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    val isRefreshing = state is Result.Loading && (state as? Result.Success<*>) != null

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = { viewModel.fetchMovies() }
    ) {
        when (state) {
            is Result.Loading -> {
                if ((state as? Result.Success<*>) == null) {
                    Box(
                        Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
            }

            is Result.Error -> Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Erro ao carregar filmes")
            }

            is Result.Success -> {
                val movies = (state as Result.Success<List<Movie>>).data

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(movies) { movie ->
                        MovieItem(movie = movie) {
                            //click
                            navController.navigate(Routes.movieDetailRoute(movie.id))
                        }
                        Divider()
                    }
                }
            }
        }
    }
}
