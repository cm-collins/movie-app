/**
 * DATA LAYER: MovieResponseDto
 * 
 * Concept: This is a "Wrapper DTO". APIs often return results inside a parent 
 * object (like 'results', 'data', or 'items') along with metadata like 
 * page numbers or total results.
 * 
 * Key Concepts:
 * 1. Encapsulation: By modeling the full API response, we can easily access 
 *    both the list of movies and any other metadata the TMDB API provides.
 * 2. Serialization: This class allows Kotlinx Serialization to understand 
 *    the top-level structure of the JSON response.
 */
package com.example.movieapp.movieapi.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponseDto(
    val results: List<MovieDto>
)
