package com.example.movieapp.movieapi.domain.repository

import com.example.movieapp.movieapi.domain.model.Movie

interface MovieApiRepository {
    suspend fun  getTrendingMovies(): List<Movie>

}