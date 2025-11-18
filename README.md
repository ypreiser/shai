# Kid-Safe Website Wrapper Apps

Android wrapper applications for kid-safe websites. Perfect for parents using Google Family Link to control which websites their children can access.

## Why Use This?

Instead of giving kids access to a full web browser, create separate apps for each approved website:
- Each app only accesses ONE specific website
- Kids can't navigate to random sites
- Use Google Family Link to control each app individually
- Set different time limits per website/app
- Install/uninstall apps as needed

## Pre-configured Websites

The following apps are ready to build:

1. **Shay Le Yeladim** - Jewish educational content
2. **YouTube Kids** - Kid-safe videos
3. **Khan Academy** - Educational platform
4. **PBS Kids** - Educational games and videos
5. **National Geographic Kids** - Science and nature content

## Quick Start

### Build a Specific App

```bash
# Build Shay Le Yeladim app
./gradlew assembleShayleyeladimDebug

# Build YouTube Kids app
./gradlew assembleYoutubekidsDebug

# Build Khan Academy app
./gradlew assembleKhanacademyDebug

# Build PBS Kids app
./gradlew assemblePbskidsDebug

# Build Nat Geo Kids app
./gradlew assembleNatgeokidsDebug
```

### Install on Device

```bash
# Install Shay Le Yeladim
./gradlew installShayleyeladimDebug

# Install YouTube Kids
./gradlew installYoutubekidsDebug

# etc.
```

### Build ALL Apps at Once

```bash
./gradlew assembleDebug
```

This creates separate APK files for each website in:
`app/build/outputs/apk/`

## Adding a New Website

It's super easy! Just edit `app/build.gradle` and add a new flavor:

```gradle
// Inside the productFlavors block, add:
mynewsite {
    dimension "website"
    applicationId "com.kidsafe.mynewsite"
    manifestPlaceholders = [appName: "My New Site"]
    buildConfigField "String", "WEBSITE_URL", "\"https://example.com\""
    buildConfigField "String", "ALLOWED_DOMAIN", "\"example.com\""
}
```

### Field Explanations:

- **mynewsite**: Flavor name (lowercase, no spaces, used in build commands)
- **applicationId**: Unique package name (must be different for each app)
- **appName**: App name shown on the device home screen
- **WEBSITE_URL**: The exact URL to load when the app starts
- **ALLOWED_DOMAIN**: Domain filter - app can only navigate to URLs containing this

### Example: Adding Disney Jr

```gradle
disneyjr {
    dimension "website"
    applicationId "com.kidsafe.disneyjr"
    manifestPlaceholders = [appName: "Disney Junior"]
    buildConfigField "String", "WEBSITE_URL", "\"https://disneyjunior.disney.com\""
    buildConfigField "String", "ALLOWED_DOMAIN", "\"disneyjunior.disney.com\""
}
```

Then build it:
```bash
./gradlew assembleDisneyjrDebug
```

## Using with Google Family Link

1. Build and install the apps you want your child to access
2. In Family Link, you can:
   - Approve/block each app individually
   - Set daily time limits per app
   - See how much time is spent in each app
   - Require approval before installing new apps

3. Don't install the regular browser apps (Chrome, Firefox, etc.)

## Technical Details

- **Min SDK**: 21 (Android 5.0 Lollipop)
- **Target SDK**: 34 (Android 14)
- **Language**: Kotlin
- **Build System**: Gradle with Product Flavors

## Features

- Full WebView integration for seamless browsing
- JavaScript enabled for dynamic content
- Back button navigation within the allowed site
- Domain filtering - prevents navigation to other sites
- Optimized for both portrait and landscape
- Network state monitoring
- RTL (Right-to-Left) support for Hebrew content

## Project Structure

```
app/
├── src/
│   └── main/
│       ├── java/com/shayleyeladim/app/
│       │   └── MainActivity.kt        # Smart - reads config from BuildConfig
│       ├── res/
│       │   ├── layout/
│       │   │   └── activity_main.xml
│       │   └── values/
│       │       ├── strings.xml
│       │       └── colors.xml
│       └── AndroidManifest.xml        # Uses manifestPlaceholders for app name
└── build.gradle                       # ADD NEW WEBSITES HERE!
```

## Permissions

All apps require:
- `INTERNET`: To load web content
- `ACCESS_NETWORK_STATE`: To check network connectivity

## Security Notes

- Each app can ONLY navigate within its configured domain
- Attempts to navigate to other sites are blocked
- No way for kids to bypass the domain filter from within the app
- Each app is isolated with its own package name

## Prerequisites

- Android Studio (latest version recommended)
- JDK 8 or higher
- Android SDK

## Tips

- Start with just a few approved sites
- Monitor usage through Family Link
- Kids can't uninstall apps without your permission in Family Link
- Each app is completely independent - uninstalling one doesn't affect others

## Need Help?

Common build commands:
```bash
# List all available build variants
./gradlew tasks --all | grep assemble

# Clean build
./gradlew clean

# Build release versions (for publishing)
./gradlew assembleRelease
```
