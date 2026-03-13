/**
 * DOMAIN LAYER: MovieApiRepository
 * 
 * Concept: This is an interface that defines the data operations our app can perform.
 * 
 * Key Concepts:
 * 1. Dependency Inversion: The ViewModel depends on this interface, not the 
 *    actual implementation. This allows us to swap the data source (API vs Mock) 
 *    easily for testing.
 * 2. Contract: It acts as a contract between the Data layer and the UI layer. 
 *    The Domain layer defines WHAT data is needed, while the Data layer defines 
 *    HOW to get it.
 */
package com.example.movieapp.movieapi.domain.repository

import com.example.movieapp.movieapi.domain.model.Movie

interface MovieApiRepository {
    /**
     * Retrieves a list of trending movies.
     * @return A list of clean Domain Movie models.
     */
    suspend fun getTrendingMovies(): List<Movie>
}
