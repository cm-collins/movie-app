package com.example.movieapp.movieapi.ui

import com.example.movieapp.movieapi.domain.model.Movie

sealed interface MoviesUiState {
    object Loading : MoviesUiState
    data class  Success (val movies: List<Movie>): MoviesUiState
    data class Error(val errorMessage: String): MoviesUiState
}
