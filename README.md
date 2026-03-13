# Movie App

A modern Android application built with Jetpack Compose that fetches and displays the latest movies using [The Movie Database (TMDB) API](https://www.themoviedb.org/documentation/api).

## 🚀 Features
- Fetch and display latest movies.
- Built using modern Android development tools and practices.
- Follows Clean Architecture and **MVVM (Model-View-ViewModel)** design pattern.

## 🛠️ Prerequisites

Before you begin, ensure you have the following:

1.  **Android Studio**: The latest version of Android Studio (Hedgehog or newer recommended).
2.  **JDK**: Java Development Kit 11 or higher.
3.  **TMDB API Key**: You need an API key to fetch movie data.
    -   Create an account on [TheMovieDB](https://www.themoviedb.org/).
    -   Navigate to your account settings and apply for an API Key.
    -   Once approved, you'll find your API Key in the "API" section.

## ⚙️ Setup & Configuration

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/movie-app.git
    ```

2.  **Add your TMDB API Key**:
    For security, do not hardcode your API key in the source code. It is recommended to add it to your `local.properties` file:
    
    Open `local.properties` in the root directory and add:
    ```properties
    TMDB_API_KEY=your_api_key_here
    ```
    *(Note: Ensure you have the Secrets Gradle Plugin configured or manually read this property in your `build.gradle.kts`)*

3.  **Build the Project**:
    Open the project in Android Studio and let Gradle sync. Then, click the **Run** button.

## 🏗️ Architecture

This project follows the **MVVM (Model-View-ViewModel)** architecture pattern:
-   **Model**: Represents the data layer (Retrofit services, Repositories).
-   **View**: Jetpack Compose UI components that observe the ViewModel.
-   **ViewModel**: Acts as a bridge between the Model and the View, managing UI state and business logic.

## 📚 Libraries Used
-   [Jetpack Compose](https://developer.android.com/jetpack/compose) - Modern UI toolkit.
-   [Retrofit](https://square.github.io/retrofit/) - Type-safe HTTP client for API calls.
-   [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) - For asynchronous programming.
-   [ViewModel & LiveData/Flow](https://developer.android.com/topic/libraries/architecture/viewmodel) - Architecture components.
-   [Coil](https://coil-kt.github.io/coil/) - Image loading library for Compose.
-   [Hilt/Dagger](https://developer.android.com/training/dependency-injection/hilt-android) (Optional/Planned) - Dependency Injection.

## 📝 License
This project is for educational purposes. Data provided by [TMDB](https://www.themoviedb.org/).
