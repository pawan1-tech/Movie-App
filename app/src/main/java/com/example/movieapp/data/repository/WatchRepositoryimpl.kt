package com.example.movieapp.data.repository

import com.example.movieapp.data.api.WatchModeApi
import com.example.movieapp.data.mapper.WatchMapper
import com.example.movieapp.data.model.WatchContent
import io.reactivex.Single

class WatchRepositoryimpl(
    private val api: WatchModeApi,
    private val mapper: WatchMapper,
) : WatchRepository {
    override fun getMoviesAndTvShows(): Single<Pair<List<WatchContent>, List<WatchContent>>> =
        Single.zip(
            api
                .getMovies()
                .map { mapper.mapResponseListToWatchContent(it.results) },
            api
                .getTvShows()
                .map { mapper.mapResponseListToWatchContent(it.results) },
        ) { movies, tvShows ->
            Pair(movies, tvShows)
        }

    override suspend fun getContentDetails(
        contentId: String,
        isMovie: Boolean,
    ): WatchContent =
        if (isMovie) {
            mapper.mapResponseToWatchContent(api.getMovieDetails(contentId.toInt()))
        } else {
            mapper.mapResponseToWatchContent(api.getMovieDetails(contentId.toInt()))
        }
}
