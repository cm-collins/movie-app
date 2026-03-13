package com.example.movieapp.movieapi.data.repository

import com.example.movieapp.movieapi.data.MovieApiService
import com.example.movieapp.movieapi.data.mapper.toDomain
import com.example.movieapp.movieapi.domain.model.Movie
import com.example.movieapp.movieapi.domain.repository.MovieApiRepository

class MovieRepoImpl (val movieApiService: MovieApiService): MovieApiRepository {
    override suspend fun getTrendingMovies(): List<Movie> {
        return  movieApiService.getPopularMovies().map { it.toDomain() }
    }
    }