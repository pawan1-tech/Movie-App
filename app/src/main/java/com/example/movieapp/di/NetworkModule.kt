package com.example.movieapp.di

import com.example.movieapp.BuildConfig // Corrected BuildConfig import
import com.example.movieapp.data.api.WatchModeApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule =
    module {
        single {
            provideAuthInterceptor()
        }
        single {
            provideOkHttpClient(get()) // Koin will provide the authInterceptor defined above
        }

        single {
            Retrofit
                .Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .client(get())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        single {
            get<Retrofit>().create(WatchModeApi::class.java)
        }
    }

private fun provideAuthInterceptor() =
    Interceptor { chain ->
        val original = chain.request()
        val originalUrl = original.url

        val url =
            originalUrl
                .newBuilder()
                .addQueryParameter("api_key", "5746bbc1d10942551fd1f6c41b137869")
                // Using BuildConfig
                .build()
        val request =
            original
                .newBuilder()
                .url(url)
                .build()
        chain.proceed(request)
    }

private fun provideOkHttpClient(authInterceptor: Interceptor) =
    OkHttpClient
        .Builder()
        .addInterceptor(authInterceptor)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
            },
        ).connectTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .build()

// private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
//    .baseUrl("https://api.themoviedb.org/3/")
//    .client(okHttpClient)
//    .addConverterFactory(GsonConverterFactory.create())
//    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//    .build()

// private fun provideWatchModeApi(retrofit: Retrofit): WatchModeApi = retrofit.create(WatchModeApi::class.java)
