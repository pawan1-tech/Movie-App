package com.example.movieapp.presentation.home

import com.example.movieapp.data.model.WatchContent

sealed class HomeState {
    object Loading : HomeState()

    data class Success(
        val movies: List<WatchContent>,
        val tvShows: List<WatchContent>,
    ) : HomeState()

    data class Error(
        val message: String,
    ) : HomeState()
}
