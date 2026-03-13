/**
 * DATA LAYER: MovieApiService
 * 
 * Concept: The API Service is responsible for making the actual network requests.
 * In MVVM, this is often the lowest level of the data layer.
 * 
 * Key Concepts:
 * 1. Ktor HttpClient: Used to perform HTTP operations (GET, POST, etc.).
 * 2. Suspend Functions: Leverages Kotlin Coroutines for non-blocking network calls,
 *    ensuring the UI remains responsive while waiting for data.
 * 3. Type-Safe Requests: Uses Ktor's .body() to automatically deserialize the JSON 
 *    response into our MovieResponseDto.
 */
package com.example.movieapp.movieapi.data

import com.example.movieapp.movieapi.data.remote.MovieDto
import com.example.movieapp.movieapi.data.remote.MovieResponseDto
import com.example.movieapp.movieapi.network.NetworkConstants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiService (val httpClient: HttpClient) {

    /**
     * Fetches popular movies from the TMDB API.
     * @return A list of MovieDto objects directly from the network.
     */
    suspend fun getPopularMovies(): List<MovieDto> {
        val response: MovieResponseDto =
            httpClient.get("${NetworkConstants.BASE_URL}movie/popular")
            {
                // Passing the API_KEY as a query parameter
                parameter("api_key", NetworkConstants.API_KEY)
            }.body()

        return response.results
    }
}
