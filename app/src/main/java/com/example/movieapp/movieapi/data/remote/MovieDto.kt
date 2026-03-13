/**
 * DATA LAYER: Remote Data Transfer Object (DTO)
 * 
 * Concept: DTOs are classes used to represent the raw data structure returned by an API.
 * In MVVM, we keep DTOs separate from our Domain models to prevent API changes 
 * from breaking our entire application logic.
 *
 * @Serializable: Annotation from Kotlinx Serialization that allows this class 
 * to be converted from JSON to a Kotlin Object.
 * @SerialName: Maps the JSON key name (e.g., "poster_path") to a Kotlin-friendly 
 * variable name (e.g., "posterPath").
 */
package com.example.movieapp.movieapi.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDto(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String?,
)
