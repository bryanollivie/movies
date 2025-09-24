package com.example.comics.movie.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.comics.movie.ui.features.movies.MovieListScreen

object Routes {
    const val EXCHANGES_LIST = "movie_list"

}

@SuppressLint("NewApi")
@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.EXCHANGES_LIST
    ) {
        composable(Routes.EXCHANGES_LIST) {
            MovieListScreen(navController = navController)
        }

    }
}
