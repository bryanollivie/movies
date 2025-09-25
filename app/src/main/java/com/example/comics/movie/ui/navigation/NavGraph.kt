package com.example.comics.movie.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.comics.movie.ui.features.movies.MovieListScreen
import com.example.comics.movie.ui.features.home.HomeScreen
import com.example.comics.movie.ui.features.moviedetail.MovieDetailScreen

object Routes {
    const val HOME_SCREEN = "home_screen"
    const val MOVIES_LIST = "movie_list"
    const val MOVIE_DETAIL_BASE = "movie_detail"
    const val ARG_MOVIE_ID = "movieId"
    const val MOVIE_DETAIL = "$MOVIE_DETAIL_BASE/{$ARG_MOVIE_ID}"

    fun movieDetailRoute(id: Int?) = "$MOVIE_DETAIL_BASE/$id"

}

@SuppressLint("NewApi")
@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME_SCREEN
    ) {

        composable(Routes.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }

        composable(Routes.MOVIES_LIST) {
            MovieListScreen(navController = navController)
        }

        composable(
            route = Routes.MOVIE_DETAIL,
            arguments = listOf(navArgument(Routes.ARG_MOVIE_ID) { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId") ?: 0
            MovieDetailScreen(movieId = movieId, navController = navController)
        }

    }
}
