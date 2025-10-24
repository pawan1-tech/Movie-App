package com.example.movieapp.domain.usecase

import android.adservices.adid.AdId
import com.example.movieapp.data.model.WatchContent
import com.example.movieapp.data.repository.WatchRepository

class GetContentDetailsUseCase(
    private val repository: WatchRepository,
) {
    suspend operator fun invoke(
        contentId: String,
        isMovie: Boolean,
    ): WatchContent = repository.getContentDetails(contentId, isMovie)
}
