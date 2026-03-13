/**
 * DEPENDENCY INJECTION LAYER: AppModule
 * 
 * Concept: Dependency Injection (DI) is a design pattern where an object receives 
 * other objects that it depends on. We use Koin as our DI framework.
 * 
 * Key Concepts:
 * 1. Singletons (single): Creates a single instance of an object that is shared 
 *    across the entire application (e.g., HttpClient, ApiService).
 * 2. ViewModel (viewModel): A special Koin DSL to provide ViewModels. It ensures 
 *    the ViewModel is correctly tied to the Android Lifecycle.
 * 3. get(): Koin automatically resolves dependencies. For example, MovieApiService 
 *    needs an HttpClient, so 'get()' finds the 'single' HttpClient we defined.
 * 4. Decoupling: This file centralizes object creation, making it easy to swap 
 *    implementations (e.g., for testing) without touching the actual classes.
 */
package com.example.movieapp.movieapi.di

import com.example.movieapp.movieapi.data.MovieApiService
import com.example.movieapp.movieapi.data.repository.MovieRepoImpl
import com.example.movieapp.movieapi.domain.repository.MovieApiRepository
import com.example.movieapp.movieapi.network.MovieNetworkClient
import com.example.movieapp.movieapi.ui.MovieViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Providing the Ktor HttpClient
    single { MovieNetworkClient.createClient() }
    
    // Providing the Remote Data Source
    single { MovieApiService(get()) }
    
    // Binding the Repository Interface to its Implementation
    single<MovieApiRepository> { MovieRepoImpl(get()) }
    
    // Providing the ViewModel for the Movie Screen
    viewModel { MovieViewModel(get()) }
}
