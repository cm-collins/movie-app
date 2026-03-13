package com.example.movieapp.movieapi.data.mapper

import com.example.movieapp.movieapi.data.remote.MovieDto
import com.example.movieapp.movieapi.domain.Movie
import com.example.movieapp.movieapi.network.NetworkConstants.IMAGE_BASE

fun MovieDto.toDomain() : Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = posterPath?.let { IMAGE_BASE + it } ?: ""
    )
}

