# Silent TTS

A minimal Android text-to-speech engine that completes speech requests silently.

No models, dictionaries, language detection, third-party runtime libraries, network access, or background jobs. It accepts language requests without analyzing text and completes the TTS callback without emitting audio samples.

## Install

Download the APK from [Releases](https://github.com/Zero-Dragon/silent-tts/releases), install it, and select **Silent TTS** as the preferred engine in Android's text-to-speech settings. You do not need to change your system language.

Android 8.0 (API 26) or newer is required. Package name: `local.silent.tts`.

The app contains only a short description and an **Open TTS settings** button. To restore speech, select another engine in system settings.

## Behavior and limitations

- Speech requests complete immediately without sound.
- Apps using their own speech engine or audio playback are unaffected.
- Apps that advance on completion may move through text rapidly.
- The Android service still has normal process and IPC overhead. Memory and battery usage have not been benchmarked.
- The initial version was confirmed selectable by the user on their device. Version 1.1 changes only the visible name and description; it has been compiled but has not been device-tested.

## Build

Use JDK 17 or newer, Android SDK Platform 36, and Gradle 8.13 (included wrapper). Set `ANDROID_HOME` to your Android SDK, or create an untracked `local.properties` with `sdk.dir`.

```sh
./gradlew assembleDebug
```

On Windows use `gradlew.bat assembleDebug`. The installable debug APK is written to `app/build/outputs/apk/debug/`. Android tooling creates a local debug key if needed.

`assembleRelease` produces an unsigned release APK. Sign it with your own key using Android's signing tools. The key for the published APK is private and is not included. Builds signed with a different key cannot update the published APK without uninstalling it first.

## License

MIT. See [LICENSE](LICENSE).
