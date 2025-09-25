package com.example.comics.movie.ui.features.moviedetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.comics.movie.core.common.Result
import com.example.comics.movie.domain.model.MovieDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(
    navController: NavController,
    movieId: Int,
    viewModel: MovieDetailViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(movieId) {
        viewModel.loadMovieDetail(movieId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalhes do Filme") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator()
                }
                state.error != null -> {
                    Text("Erro: ${state.error}", color = MaterialTheme.colorScheme.error)
                }
                state.movieDetail != null -> {
                    MovieDetailContent(state.movieDetail!!)
                }
            }
        }
    }
}

@Composable
fun MovieDetailContent(movie: MovieDetail) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
            contentDescription = movie.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        movie.title?.let { Text(text = it, style = MaterialTheme.typography.headlineMedium) }
        Text(text = movie.tagline ?: "", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "⭐ ${movie.voteAverage} (${movie.voteCount} votos)")
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Lançado em: ${movie.releaseDate}")
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Duração: ${movie.runtime ?: 0} min")
        Spacer(modifier = Modifier.height(16.dp))

        movie.overview?.let { Text(text = it, style = MaterialTheme.typography.bodyLarge) }
    }
}
