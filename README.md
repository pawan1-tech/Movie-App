<p align="center">
  <img src="app/src/main/res/drawable/movie_app_banner.png" alt="Movie App Banner" width="100%" />
</p>

# 🎬 Movie-App (Jetpack Compose) — Watchmode API Assignment

![Build](https://img.shields.io/badge/build-passing-brightgreen?style=flat-square)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue?style=flat-square&logo=kotlin)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-UI-orange?style=flat-square&logo=android)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=flat-square)

A **Movie & TV Show discovery Android app** built with **Jetpack Compose** that demonstrates fetching and displaying content from the **Watchmode API**.  
This project satisfies assignment requirements: **simultaneous API calls using RxKotlin `Single.zip`**, **MVVM architecture**, **Dependency Injection (Koin)**, **Retrofit networking**, **shimmer loading states**, **graceful error handling**, and a **details screen**.

---

## 📑 Contents
- [About](#about)
- [Features (mapped to assignment requirements)](#features-mapped-to-assignment-requirements)
- [Architecture & Tech Stack](#architecture--tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started--setup--configuration)
- [Build & Run](#build--run)
- [Testing & Quality](#testing--quality)
- [Assumptions & Known Issues](#assumptions--known-issues)
- [Future Improvements](#future-improvements)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## 🧩 About

This app provides a simple, practical Movie & TV Show discovery experience:

- Home screen lists **movies and TV shows** (switchable via tabs/toggle).
- Tap any item to view **details** (title, description, release date, poster).
- **Shimmer placeholders** show while data loads.
- **Simultaneous API calls** using RxKotlin `Single.zip` to fetch movies and TV shows concurrently.

---

## 🎯 Features (mapped to assignment requirements)

### 1. Home Screen
- Fetches and displays movies and TV shows from the Watchmode API.  
- Top **tabs/toggle** to switch between Movies and TV Shows.  
- **Shimmer effect** for loading state.  
  ![Home Screen Screenshot](app/src/main/res/drawable/homemoviescreen.png)

---

### 2. Details Screen
- Displays **title, description, release date**, and **poster image**.  
- Shimmer placeholders while details or images load.  
  ![Details Screen Screenshot](app/src/main/res/drawable/details_screen.png)

---

### 3. API Integration
- **Retrofit** used for networking.  
- **Two API calls executed simultaneously** using RxKotlin `Single.zip`, results merged in ViewModel.  
- Models map API responses to UI-friendly data.

---

### 4. Error Handling
- Network/unexpected errors shown via **Snackbar (Compose Scaffold)** or **Toast** with retry action.

---

### 5. Architecture & Patterns
- **MVVM architecture**: ViewModel → Repository → DataSource.  
- **Dependency Injection**: Koin.  
- **Reactive handling**: RxKotlin (`Single.zip`) + coroutines (where appropriate).  
- **Image loading**: Coil.  
- **Shimmer effect**: Accompanist Placeholder or custom shimmer.

---

## 🏗 Architecture & Tech Stack

| Layer | Technology |
|-------|-------------|
| Language | Kotlin |
| UI | Jetpack Compose |
| Networking | Retrofit + OkHttp |
| Reactive | RxJava / RxKotlin (`Single.zip`) |
| Dependency Injection | Koin |
| Image Loading | Coil (Compose) |
| Shimmer | Accompanist Placeholder |
| Unit Testing | JUnit, Mockito / MockK |
| Build System | Gradle (Kotlin DSL) |

---

## 📁 Project Structure

