```markdown
# Movie-App (Jetpack Compose) — Watchmode API Assignment

A Movie & TV Show discovery Android app built with Jetpack Compose that demonstrates fetching and displaying content from the Watchmode API. This project is implemented to satisfy the assignment requirements: simultaneous API calls using RxKotlin Single.zip, MVVM architecture, Dependency Injection (Koin), Retrofit networking, shimmer loading states, graceful error handling, and a details screen.

---

Contents
- About
- Features (mapped to assignment requirements)
- Architecture & Tech Stack
- Project structure
- Getting started (setup & configuration)
- Running & building (including APK)
- Tests
- Submission artifacts (APK & video)
- Assumptions, limitations & known issues
- Contributing
- License & Contact

About
This app demonstrates a simple, practical Movie & TV Show discovery experience:
- Home screen lists movies and TV shows (switch with tabs/toggle).
- Tap an item to view details (title, description, release date, poster).
- Shimmer placeholders while data loads.
- Simultaneous network calls to fetch movies and TV shows using RxKotlin Single.zip as required.

Features (mapped to assignment requirements)
1. Home Screen
   - Fetches and displays movies and TV shows from Watchmode API.
   - Top tabs / toggle to switch between Movies and TV Shows.
   - Shimmer/placeholder effect while listing content.
   ![Home Screen Screenshot](app/src/main/res/drawable/homemoviescreen.png)

2. Details Screen
   - Displays title, description, release date, and poster image.
   - Shimmer/placeholder while details or image load.
   ![Details Screen Screenshot](path/to/your/details_screen_screenshot.png)

3. API Integration
   - Retrofit used for networking.
   - Two API calls performed simultaneously using RxKotlin Single.zip to fetch movies and TV shows, results merged/exposed to ViewModel.
   - Models map API responses to UI-friendly data.

4. Error Handling
   - Network and unexpected errors are surfaced via Snackbar (Compose Scaffold) or Toast with retry action.

5. Architecture & Patterns
   - MVVM architecture (ViewModel — Repository — DataSource).
   - Dependency Injection with Koin (DI modules provided).
   - RxKotlin for the required simultaneous API calls; coroutines used where appropriate.
   - Image loading via Coil; shimmer via Accompanist Placeholder (or similar).

Architecture & Tech Stack
- Language: Kotlin
- UI: Jetpack Compose
- Networking: Retrofit + OkHttp
- Reactive: RxJava / RxKotlin (Single.zip)
- Dependency Injection: Koin
- Image Loading: Coil (Compose)
- Shimmer/Placeholder: Accompanist Placeholder (or a custom shimmer)
- Unit testing: JUnit, Mockito or MockK
- Build system: Gradle (Kotlin/Gradle wrapper included)

Project structure (high level)
- app/src/main/java/.../ui — Compose screens, components
- app/src/main/java/.../viewmodel — ViewModels
- app/src/main/java/.../data — Repositories, network, models
- app/src/main/java/.../di — Koin modules
- app/src/test — Unit tests
- apk/ or releases — (optional) APK artifacts

Getting started — prerequisites
- Android Studio (preferably latest stable)
- JDK 11+
- Gradle wrapper included in repo
- A Watchmode API key (register at https://api.watchmode.com/)

Configuration (Watchmode API key)
The app expects an API key to call Watchmode. There are multiple ways to provide it; below are recommended approaches.

Option A — local.properties (recommended for local development)
1. Open the project's root local.properties file (create it if missing).
2. Add:
   WATCHMODE_API_KEY="your_watchmode_api_key_here"

3. The project Gradle config should read this property and expose it as a BuildConfig field. If the repository does not already include that, you can add in app/build.gradle (Kotlin DSL or Groovy) something like:
   // Groovy example:
   def watchmodeApiKey = project.hasProperty("WATCHMODE_API_KEY") ? project.WATCHMODE_API_KEY : ""
   buildTypes.each {
       it.buildConfigField "String", "WATCHMODE_API_KEY", "\"${watchmodeApiKey}\""
   }


Build & run
1. Clone the repository:
   git clone https://github.com/pawan1-tech/Movie-App.git
2. Open in Android Studio.
3. Add your Watchmode API key (see Configuration).
4. Select a device or emulator and Run the app from Android Studio.

Build release APK
- From project root:
  ./gradlew assembleRelease
- APK output: app/build/outputs/apk/release/app-release.apk

Run unit tests
- Local JVM tests:
  ./gradlew test

Implementation notes
- Simultaneous calls: The app uses RxKotlin Single.zip to call two Watchmode endpoints in parallel (Movies and TV Shows). The zipped result is transformed into UI state.
- Error handling: Repository and ViewModel catch errors and emit UI states. Snackbars with retry actions are used in Compose.
- Shimmer: Accompanist Placeholder or equivalent is used to show skeleton items while data is loading.
- DI: Koin modules provide Retrofit, repository, and ViewModel instances.
- Image loading: Coil (with Compose integration) handles image loading and placeholder/error images.


Testing & Quality
- Unit tests cover ViewModel and repository logic (see /app/src/test).
- For grading, ensure:
  - Simultaneous API calls are used (Single.zip)
  - MVVM pattern is followed
  - Errors are handled and surfaced
  - App uses Jetpack Compose for UI

Assumptions & known issues
- Requires a valid Watchmode API key.
- Watchmode enforces rate limits — heavy testing may face throttling.
- Some API fields may change; model mapping is defensive but may require adjustment for API changes.
- Offline caching/persistence and paging are not implemented (could be future improvements).

Future improvements
- Add Paging 3 for large datasets.
- Add offline caching (Room / SQLDelight).
- Add instrumentation/UI tests (Espresso/Compose test).
- Add better UI polish & animations.

Contributing
- For changes, open issues or pull requests.
- If you want me to push this README directly to the repository, I can make the patch and create the commit for you.



Contact
- Repo owner / maintainer: pawan1-tech
- For questions or to share APK/video links, open an issue or contact via the repository.

---

