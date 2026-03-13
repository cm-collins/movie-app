package com.example.movieapp.movieapi.data
import com.example.movieapp.movieapi.data.remote.MovieDto
import com.example.movieapp.movieapi.data.remote.MovieResponseDto
import com.example.movieapp.movieapi.network.NetworkConstants
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiService (val httpClient: HttpClient) {

    suspend fun getPopularMovies(): List<MovieDto> {
        val response: MovieResponseDto =
            httpClient.get("${NetworkConstants.BASE_URL}movie/popular")
            {
                parameter("api_key", NetworkConstants.API_KEY)
            }.body()

        return  response.results


    }
}
