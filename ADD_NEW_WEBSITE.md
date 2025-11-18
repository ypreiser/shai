# How to Add a New Website - Quick Guide

## Step 1: Edit app/build.gradle

Open `app/build.gradle` and find the `productFlavors` section (around line 19).

Add your new website using this template:

```gradle
yourwebsite {
    dimension "website"
    applicationId "com.kidsafe.yourwebsite"
    manifestPlaceholders = [appName: "Your Website Name"]
    buildConfigField "String", "WEBSITE_URL", "\"https://yourwebsite.com\""
    buildConfigField "String", "ALLOWED_DOMAIN", "\"yourwebsite.com\""
}
```

## Step 2: Customize the Values

Replace these values:

| Field | What to Change | Example |
|-------|---------------|---------|
| `yourwebsite` | Short name, lowercase, no spaces | `starfall` |
| `com.kidsafe.yourwebsite` | Unique package ID | `com.kidsafe.starfall` |
| `Your Website Name` | App name shown on phone | `Starfall` |
| `https://yourwebsite.com` | Starting URL | `https://www.starfall.com` |
| `yourwebsite.com` | Domain to allow | `starfall.com` |

## Step 3: Build the App

```bash
./gradlew assembleYourwebsiteDebug
```

Replace `Yourwebsite` with your flavor name (first letter capitalized).

## Step 4: Install on Device

```bash
./gradlew installYourwebsiteDebug
```

Or find the APK in:
```
app/build/outputs/apk/yourwebsite/debug/
```

## Real Example: Adding Starfall

```gradle
starfall {
    dimension "website"
    applicationId "com.kidsafe.starfall"
    manifestPlaceholders = [appName: "Starfall"]
    buildConfigField "String", "WEBSITE_URL", "\"https://www.starfall.com\""
    buildConfigField "String", "ALLOWED_DOMAIN", "\"starfall.com\""
}
```

Build command:
```bash
./gradlew assembleStarfallDebug
```

## Common Kid-Safe Websites

Here are some ready-to-use configurations:

### ABCmouse
```gradle
abcmouse {
    dimension "website"
    applicationId "com.kidsafe.abcmouse"
    manifestPlaceholders = [appName: "ABCmouse"]
    buildConfigField "String", "WEBSITE_URL", "\"https://www.abcmouse.com\""
    buildConfigField "String", "ALLOWED_DOMAIN", "\"abcmouse.com\""
}
```

### Starfall
```gradle
starfall {
    dimension "website"
    applicationId "com.kidsafe.starfall"
    manifestPlaceholders = [appName: "Starfall"]
    buildConfigField "String", "WEBSITE_URL", "\"https://www.starfall.com\""
    buildConfigField "String", "ALLOWED_DOMAIN", "\"starfall.com\""
}
```

### Funbrain
```gradle
funbrain {
    dimension "website"
    applicationId "com.kidsafe.funbrain"
    manifestPlaceholders = [appName: "Funbrain"]
    buildConfigField "String", "WEBSITE_URL", "\"https://www.funbrain.com\""
    buildConfigField "String", "ALLOWED_DOMAIN", "\"funbrain.com\""
}
```

### Coolmath Games
```gradle
coolmath {
    dimension "website"
    applicationId "com.kidsafe.coolmath"
    manifestPlaceholders = [appName: "Coolmath Games"]
    buildConfigField "String", "WEBSITE_URL", "\"https://www.coolmathgames.com\""
    buildConfigField "String", "ALLOWED_DOMAIN", "\"coolmathgames.com\""
}
```

### Seussville
```gradle
seussville {
    dimension "website"
    applicationId "com.kidsafe.seussville"
    manifestPlaceholders = [appName: "Seussville"]
    buildConfigField "String", "WEBSITE_URL", "\"https://www.seussville.com\""
    buildConfigField "String", "ALLOWED_DOMAIN", "\"seussville.com\""
}
```

### NASA Kids Club
```gradle
nasakids {
    dimension "website"
    applicationId "com.kidsafe.nasakids"
    manifestPlaceholders = [appName: "NASA Kids"]
    buildConfigField "String", "WEBSITE_URL", "\"https://www.nasa.gov/kidsclub\""
    buildConfigField "String", "ALLOWED_DOMAIN", "\"nasa.gov\""
}
```

### Nick Jr
```gradle
nickjr {
    dimension "website"
    applicationId "com.kidsafe.nickjr"
    manifestPlaceholders = [appName: "Nick Jr"]
    buildConfigField "String", "WEBSITE_URL", "\"https://www.nickjr.com\""
    buildConfigField "String", "ALLOWED_DOMAIN", "\"nickjr.com\""
}
```

## Tips

- **Flavor name** should be simple, one word, lowercase
- **Application ID** must be unique for each app - Android won't install two apps with the same ID
- **Domain filter** can be broad (`google.com`) or specific (`kids.google.com`)
- Test each app to make sure the website works properly in a WebView
- Some sites may not work well in WebViews (rare, but possible)

## Need to Remove a Website?

Just delete the entire block from `productFlavors` and rebuild.

## Troubleshooting

**Build fails?**
- Check for typos in your flavor block
- Make sure all quotes are correct: `"\"https://example.com\""`
- Run `./gradlew clean` then try again

**App installs but shows blank screen?**
- Check that WEBSITE_URL is correct
- Some websites block being loaded in WebViews (security feature)
- Try accessing the URL in Chrome first to verify it works

**Can't install multiple apps?**
- Make sure each `applicationId` is unique
- Each app needs a different package name
