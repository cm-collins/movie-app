/**
 * DATA LAYER: MovieRepoImpl
 * 
 * Concept: The Repository Implementation is where we decide how to fetch data.
 * It implements the interface defined in the Domain layer.
 * 
 * Key Concepts:
 * 1. Dependency Injection: We inject the 'MovieApiService' so this class doesn't 
 *    need to know how to create it.
 * 2. Mapping: The repository is responsible for taking the DTOs from the API 
 *    and converting them into Domain models using the Mapper.
 * 3. Abstraction: The UI only knows about the 'MovieApiRepository' interface, 
 *    not this specific implementation. This makes it easy to swap the data source 
 *    (e.g., adding a local database) without changing the UI.
 */
package com.example.movieapp.movieapi.data.repository

import com.example.movieapp.movieapi.data.MovieApiService
import com.example.movieapp.movieapi.data.mapper.toDomain
import com.example.movieapp.movieapi.domain.model.Movie
import com.example.movieapp.movieapi.domain.repository.MovieApiRepository

class MovieRepoImpl (val movieApiService: MovieApiService): MovieApiRepository {
    override suspend fun getTrendingMovies(): List<Movie> {
        // Fetching from API and immediately mapping to Domain models
        return movieApiService.getPopularMovies().map { it.toDomain() }
    }
}
