package com.example.movieapp.domain.usecase

import com.example.movieapp.data.model.WatchContent
import com.example.movieapp.data.repository.WatchRepository
import io.reactivex.Single

class GetMoviesAndTvShowsUseCases (private val repository: WatchRepository){
    operator fun invoke(): Single<Pair<List<WatchContent>, List<WatchContent>>> {
        return repository.getMoviesAndTvShows()
    }
}