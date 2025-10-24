package com.example.movieapp.di

import com.example.movieapp.WatchApplication
import com.example.movieapp.domain.usecase.GetContentDetailsUseCase
import com.example.movieapp.domain.usecase.GetMoviesAndTvShowsUseCases
import com.example.movieapp.presentation.details.DetailsViewModel
import com.example.movieapp.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        single { WatchApplication() }

        factory { GetContentDetailsUseCase(get()) }
        factory { GetMoviesAndTvShowsUseCases(get()) }

        viewModel { HomeViewModel(get()) }
        viewModel { DetailsViewModel(get()) }
    }
