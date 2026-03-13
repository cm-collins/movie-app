package com.example.movieapp.movieapi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.movieapi.ui.MovieScreen
import kotlinx.serialization.Serializable

@Composable
fun MovieAppNavigation(){
    val navController = rememberNavController()

    NavHost  (navController, Home){
        composable <Home> {
            MovieScreen()
        }

    }
}

@Serializable
object  Home