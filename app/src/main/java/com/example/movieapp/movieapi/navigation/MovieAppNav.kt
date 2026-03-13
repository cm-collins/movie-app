/**
 * UI LAYER: Navigation
 * 
 * Concept: Navigation in Jetpack Compose is handled using the Compose Navigation library.
 * 
 * Key Concepts:
 * 1. Bottom Navigation: A standard UI pattern for top-level navigation, providing 
 *    quick access to primary destinations.
 * 2. NavHost & NavController: Manages the backstack and navigation between composables.
 * 3. Type-Safe Routes: Using @Serializable classes for safe navigation.
 */
package com.example.movieapp.movieapi.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileDownload
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.movieapi.ui.MovieScreen
import kotlinx.serialization.Serializable

@Composable
fun MovieAppNavigation() {
    val navController = rememberNavController()
    
    // Items for the Bottom Navigation Bar (Netflix Style)
    // Using PlayArrow and FileDownload from the standard Material Icons set
    val items = listOf(
        NavigationItem("Home", Home, Icons.Default.Home),
        NavigationItem("New & Hot", NewAndHot, Icons.Default.PlayArrow),
        NavigationItem("Search", Search, Icons.Default.Search),
        NavigationItem("Downloads", Downloads, Icons.Default.FileDownload)
    )

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Color.Black,
                contentColor = Color.White,
                tonalElevation = 0.dp
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                
                items.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(item.title, fontSize = 10.sp) },
                        selected = currentDestination?.hierarchy?.any { it.hasRoute(item.route::class) } == true,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            unselectedIconColor = Color.Gray,
                            unselectedTextColor = Color.Gray,
                            indicatorColor = Color.Transparent // Netflix style doesn't use pill indicators
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Home> { MovieScreen() }
            composable<NewAndHot> { PlaceholderScreen("New & Hot") }
            composable<Search> { PlaceholderScreen("Search") }
            composable<Downloads> { PlaceholderScreen("Downloads") }
        }
    }
}

/**
 * A simple placeholder for screens we haven't built yet.
 */
@Composable
fun PlaceholderScreen(name: String) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = name, color = Color.White, style = MaterialTheme.typography.headlineMedium)
        }
    }
}

data class NavigationItem(val title: String, val route: Any, val icon: ImageVector)

@Serializable object Home
@Serializable object NewAndHot
@Serializable object Search
@Serializable object Downloads
