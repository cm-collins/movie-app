/**
 * UI LAYER: MovieViewModel
 * 
 * Concept: The ViewModel's role is to manage UI state and handle business logic interaction.
 * It survives configuration changes (like screen rotations).
 * 
 * Key Concepts:
 * 1. StateFlow: A state-holder observable flow that emits the current and new state updates.
 *    The UI 'collects' this state to know what to display.
 * 2. viewModelScope: A Coroutine scope tied to the ViewModel's lifecycle. 
 *    When the ViewModel is cleared, all running coroutines in this scope are cancelled.
 * 3. Loading/Success/Error Pattern: We use a sealed interface (MoviesUiState) to represent 
 *    the different possible states of our screen, ensuring the UI always has a predictable state.
 */
package com.example.movieapp.movieapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.movieapi.domain.repository.MovieApiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(val repository: MovieApiRepository) : ViewModel() {
    
    // MutableStateFlow is private to prevent direct modification from the View
    private val _uiState = MutableStateFlow<MoviesUiState>(MoviesUiState.Loading)
    
    // Public StateFlow that the UI observes
    val uiState: StateFlow<MoviesUiState> = _uiState

    init {
        loadPopularMovies()
    }

    /**
     * Triggers the data fetching process using a Coroutine.
     */
    private fun loadPopularMovies() {
        viewModelScope.launch {
            try {
                // Communicating with the Domain layer (Repository)
                val movies = repository.getTrendingMovies()
                _uiState.value = MoviesUiState.Success(movies)
            } catch (e: Exception) {
                // Handling potential network or mapping errors
                _uiState.value = MoviesUiState.Error(e.toString())
            }
        }
    }
}
