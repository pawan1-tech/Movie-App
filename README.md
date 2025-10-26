# Movie App

## Description
A modern Android application for browsing movies and TV shows, built with Jetpack Compose, Kotlin, and following MVVM architecture.

## Features
- Browse a list of popular movies and TV shows.
- View detailed information about each content item (e.g., poster, title, etc.).
- Switch between movie and TV show categories.
- Loading and error states with a shimmer effect for loading and a retry mechanism for errors.

## Technologies Used
- **Kotlin**: Primary language for Android development.
- **Jetpack Compose**: Modern toolkit for building native Android UI.
- **MVVM (Model-View-ViewModel)**: Architectural pattern for separating UI from business logic.
- **Retrofit**: Type-safe HTTP client for Android and Java.
- **OkHttp**: HTTP client for Android, used for logging interceptor.
- **Koin**: Dependency Injection framework.
- **Coil**: Image loading library for Android.
- **RxKotlin & RxAndroid**: Reactive extensions for Kotlin and Android (RxJava2 based).
- **Shimmer Effect**: For displaying a loading animation.

## Setup Instructions

### Prerequisites
- Android Studio Bumblebee (2021.1.1) or higher
- Kotlin plugin
- JDK 11 or higher

### Installation
1.  **Clone the repository:**
    ```bash
    git clone https://github.com/pawan1-tech/Movie-App
    ```
2.  **Open in Android Studio:**
    - Open Android Studio.
    - Select `File > Open`.
    - Navigate to the cloned `MovieApp` directory and click `Open`.
3.  **Sync Gradle:**
    - Android Studio should automatically prompt you to sync the project with Gradle. If not, click `File > Sync Project with Gradle Files`.
4.  **Add API Key:**
    - (If applicable) Obtain an API key from [Your API Provider Name] and add it to your `local.properties` file or `build.gradle.kts` as an environment variable.

### Running the App
1.  Connect an Android device or start an Android Emulator.
2.  Click the `Run` button (green triangle) in Android Studio.

## Future Enhancements
- Search functionality for movies and TV shows.
- User authentication and watchlist features.
- More detailed content information (cast, crew, reviews).
- Improved UI/UX with more animations and transitions.
- Offline support and caching.
- Pagination for large lists of content.
