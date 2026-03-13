/**
 * MovieNetworkClient is a singleton object responsible for configuring and providing
 * a Ktor HttpClient instance.
 *
 * Concepts used:
 * 1. HttpClient: The primary entry point for Ktor network operations. We use the 'Android' engine
 *    as defined in our project dependencies.
 * 2. ContentNegotiation: A Ktor plugin that allows the client to automatically handle 
 *    content types. Here, it is configured to handle JSON.
 * 3. kotlinx.serialization: The modern Kotlin library used to convert (serialize/deserialize)
 *    JSON data from the TMDB API into our Kotlin Data Transfer Objects (DTOs).
 * 4. ignoreUnknownKeys: A critical setting for production APIs. It ensures the app doesn't crash
 *    if the TMDB API adds new fields in the future that aren't defined in our MovieDto.
 */
package com.example.movieapp.movieapi.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object MovieNetworkClient {
    /**
     * Creates and configures a Ktor HttpClient.
     * We use the Android engine for native performance on the Android platform.
     */
    fun createClient(): HttpClient = HttpClient(Android) {
        // Install ContentNegotiation to handle JSON responses automatically
        install(ContentNegotiation) {
            json(Json {
                // Don't throw an exception if the API returns extra fields we don't need
                ignoreUnknownKeys = true
                // Use strict naming from @SerialName annotations
                useAlternativeNames = false
                // Make the JSON output pretty for debugging if needed
                prettyPrint = true
                // Handle cases where the API might return null for expected non-null fields
                coerceInputValues = true
            })
        }
    }
}
