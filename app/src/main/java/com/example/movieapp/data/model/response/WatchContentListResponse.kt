package com.example.movieapp.data.model.response

data class WatchContentListResponse(
    val page: String,
    val results: List<WatchContentResponse>,
    val total_page: Int,
    val total_result: Int,
)
