package com.example.movieapp.movieapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.movieapi.domain.repository.MovieApiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(val repository: MovieApiRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<MoviesUiState>(MoviesUiState.Loading)
    val uiState: StateFlow<MoviesUiState> = _uiState


    init {
        loadPopularMovies()
    }

    private fun loadPopularMovies() {
        viewModelScope.launch {
            try {
                val movies = repository.getTrendingMovies()
                _uiState.value = MoviesUiState.Success(movies)

            } catch (e: Exception) {
                _uiState.value = MoviesUiState.Error(e.toString())

            }
        }

    }


}