/**
 * DOMAIN LAYER: Movie Model
 * 
 * Concept: The Domain Model represents the data as it's used within the application's 
 * business logic and UI. 
 * 
 * Key Concepts:
 * 1. Purity: Domain models should be "pure" Kotlin classes. They should not contain 
 *    any annotations from networking (like @Serializable) or database libraries.
 * 2. Stability: While the API (Data Layer) might change, the Domain Model should 
 *    remain stable, acting as a contract for the UI.
 */
package com.example.movieapp.movieapi.domain.model

data class Movie(
    val id: Int = 0,
    val title: String,
    val overview: String,
    val posterUrl: String,
)
