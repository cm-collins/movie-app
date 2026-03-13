package com.example.movieapp.movieapi.domain

data class Movie(
    val id: Int = 0,
    val title: String,
    val overview: String,
    val posterUrl: String,
    )