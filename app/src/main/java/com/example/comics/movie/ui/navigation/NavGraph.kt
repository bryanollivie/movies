package com.example.comics.movie.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.comics.movie.ui.features.movies.MovieListScreen
import com.example.comics.movie.ui.features.start.HomeScreen
import com.example.comics.old.view.MainActivity

object Routes {
    const val HOME_SCREEN = "home_screen"
    const val MOVIES_LIST = "movie_list"
    const val OLD_LIST = "old_list"

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
        composable(Routes.OLD_LIST) {
            MainActivity()
        }

    }
}
