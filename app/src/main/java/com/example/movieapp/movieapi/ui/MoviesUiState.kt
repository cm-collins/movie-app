/**
 * UI LAYER: MoviesUiState
 * 
 * Concept: Sealed Interfaces/Classes represent restricted class hierarchies.
 * 
 * Key Concepts:
 * 1. State Modeling: We use this to model the different states the UI can be in 
 *    (Loading, Success, or Error). This makes the UI state predictable and type-safe.
 * 2. Exhaustive 'when': In the UI layer, the compiler ensures we handle all 
 *    possible states defined here, preventing "undefined" UI behaviors.
 * 3. Data Carrying: The 'Success' state carries the actual movie data, 
 *    while 'Error' carries the message, keeping the state self-contained.
 */
package com.example.movieapp.movieapi.ui

import com.example.movieapp.movieapi.domain.model.Movie

sealed interface MoviesUiState {
    object Loading : MoviesUiState
    data class Success(val movies: List<Movie>) : MoviesUiState
    data class Error(val errorMessage: String) : MoviesUiState
}
