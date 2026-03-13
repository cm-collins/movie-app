package com.example.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.movieapp.movieapi.navigation.MovieAppNavigation
import com.example.movieapp.ui.theme.MovieappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        enableEdgeToEdge()
        setContent {
            MovieappTheme {
                MovieAppNavigation()
            }
        }
    }
}
