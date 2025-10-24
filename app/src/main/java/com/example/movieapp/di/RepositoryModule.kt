package com.example.movieapp.di

import com.example.movieapp.data.mapper.WatchMapper
import com.example.movieapp.data.repository.WatchRepository
import com.example.movieapp.data.repository.WatchRepositoryimpl
import org.koin.dsl.module

val repositoryModule =
    module {
        single { WatchMapper() }
        single<WatchRepository> { WatchRepositoryimpl(get(), get()) }
    }
