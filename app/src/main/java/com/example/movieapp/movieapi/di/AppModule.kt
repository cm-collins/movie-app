package com.example.movieapp.movieapi.di

import com.example.movieapp.movieapi.data.MovieApiService
import com.example.movieapp.movieapi.data.repository.MovieRepoImpl
import com.example.movieapp.movieapi.domain.repository.MovieApiRepository
import com.example.movieapp.movieapi.network.MovieNetworkClient
import com.example.movieapp.movieapi.ui.MovieViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { MovieNetworkClient.createClient() }
    single { MovieApiService(get()) }
    single<MovieApiRepository> { MovieRepoImpl(get()) }
    viewModel { MovieViewModel(get()) }
}
