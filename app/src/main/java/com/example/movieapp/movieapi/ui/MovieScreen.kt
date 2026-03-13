package com.example.movieapp.movieapi.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieScreen(
    viewModel: MovieViewModel = koinViewModel()
) {
    val moviesUiState  by viewModel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize()
        .padding(30.dp)
    ) {
//        val movies = (moviesUiState as MoviesUiState.Success).movies

        when (moviesUiState){
             MoviesUiState.Loading -> {
                CircularProgressIndicator()
                 Text(text = "Loading Movies")
            }

            is MoviesUiState.Success -> {
                val movies = (moviesUiState as MoviesUiState.Success).movies
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                )
                {
                    items(movies){
                        movie -> MovieCard(
                            imageUrl = movie.posterUrl,
                            title = movie.title,
                            overview = movie.overview
                        )
                    }
                }

            }

            is MoviesUiState.Error -> {
                Text(text = "Error Fetching Movies")

            }

            else -> {
                Text(text = "Something went wrong")
            }


        }


    }

}

@Composable
fun MovieCard(imageUrl: String?, title: String, overview: String) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = imageUrl,
            contentDescription = title,
        )
        Text(
            text = title,
            maxLines = 1
        )
        Text(
            text = overview,
            maxLines = 4
        )
    }

}
