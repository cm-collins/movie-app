/**
 * DATA LAYER: MovieMapper
 * 
 * Concept: Mappers are responsible for converting data between different layers.
 * 
 * Key Concepts:
 * 1. Extension Functions: We use Kotlin extension functions (`MovieDto.toDomain()`) 
 *    to add mapping capabilities to our DTOs without modifying their source code.
 * 2. Data Decoupling: By mapping `MovieDto` (Remote) to `Movie` (Domain), we ensure 
 *    that the UI and Business Logic layers are not dependent on the API's data structure.
 * 3. Data Transformation: Here, we transform the partial `posterPath` from the API 
 *    into a full `posterUrl` by prepending the `IMAGE_BASE` URL.
 */
package com.example.movieapp.movieapi.data.mapper

import com.example.movieapp.movieapi.data.remote.MovieDto
import com.example.movieapp.movieapi.domain.model.Movie
import com.example.movieapp.movieapi.network.NetworkConstants.IMAGE_BASE

fun MovieDto.toDomain() : Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        // Handling nullability and transforming the path to a full URL
        posterUrl = posterPath?.let { IMAGE_BASE + it } ?: ""
    )
}
