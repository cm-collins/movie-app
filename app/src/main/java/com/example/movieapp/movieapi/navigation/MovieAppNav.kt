/**
 * UI LAYER: Navigation
 * 
 * Concept: Navigation in Jetpack Compose is handled using the Compose Navigation library.
 * It allows us to define "routes" as Kotlin objects/classes, ensuring type-safety.
 * 
 * Key Concepts:
 * 1. NavHost: The container that displays the current destination. It links the 
 *    NavController with the navigation graph.
 * 2. NavController: The central API for the Navigation component. it tracks the 
 *    back stack of composables and state of each screen.
 * 3. Type-Safe Routes: Using @Serializable objects/classes as routes (like 'Home') 
 *    prevents runtime errors caused by hardcoded string URLs.
 */
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

    // Defining the Navigation Graph
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            // The starting screen of our application
            MovieScreen()
        }
    }
}

/**
 * Route definition for the Home screen.
 * Marked with @Serializable for Type-Safe Navigation.
 */
@Serializable
object Home
