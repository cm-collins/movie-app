package com.example.movieapp.movieapi.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponseDto(
    val results: List<MovieDto>
    )
