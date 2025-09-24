package com.example.comics.movie.ui.features.movies

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.comics.movie.domain.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.comics.movie.core.common.Result

@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MovieListViewModel = hiltViewModel()) {
    val state by viewModel.uiState.collectAsState()

    when (state) {
        is Result.Loading -> CircularProgressIndicator()
        is Result.Error -> Text("Erro ao carregar filmes")
        is Result.Success -> {
            LazyColumn {
                items((state as Result.Success<List<Movie>>).data) { movie ->
                    Row (modifier = Modifier.padding(8.dp)) {
                        AsyncImage(
                            model = "https://image.tmdb.org/t/p/w500${movie.backdropPath}",
                            contentDescription = movie.title,
                            modifier = Modifier.size(120.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Column {
                            movie.title?.let { Text(it, style = MaterialTheme.typography.titleMedium) }
                            Text("⭐ ${movie.voteAverage}")
                        }
                    }
                }
            }
        }
    }
}
