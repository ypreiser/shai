# Shay Le Yeladim Android App

An Android wrapper application for the Shay Le Yeladim website (https://shayleyeladim.org.il).

## Features

- Full WebView integration for seamless browsing
- JavaScript enabled for dynamic content
- Back button navigation support
- Optimized for both portrait and landscape orientations
- Network state monitoring
- RTL (Right-to-Left) support for Hebrew content

## Technical Details

- **Min SDK**: 21 (Android 5.0 Lollipop)
- **Target SDK**: 34 (Android 14)
- **Language**: Kotlin
- **Build System**: Gradle

## Building the App

### Prerequisites

- Android Studio (latest version recommended)
- JDK 8 or higher
- Android SDK

### Build Instructions

1. Clone this repository
2. Open the project in Android Studio
3. Wait for Gradle sync to complete
4. Build and run on your device or emulator

### Gradle Commands

```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug
```

## Project Structure

```
app/
├── src/
│   └── main/
│       ├── java/com/shayleyeladim/app/
│       │   └── MainActivity.kt
│       ├── res/
│       │   ├── layout/
│       │   │   └── activity_main.xml
│       │   └── values/
│       │       ├── strings.xml
│       │       └── colors.xml
│       └── AndroidManifest.xml
└── build.gradle
```

## Permissions

The app requires the following permissions:
- `INTERNET`: To load web content
- `ACCESS_NETWORK_STATE`: To check network connectivity

## License

This is a wrapper application for the Shay Le Yeladim website.
