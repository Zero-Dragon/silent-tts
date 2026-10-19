# Silent TTS

A minimal Android text-to-speech engine that completes speech requests silently.

Use Silent TTS when an app requires a text-to-speech engine but you want speech requests to finish without sound. It accepts any requested language without analyzing the text or generating audio.

- No speech models or dictionaries.
- No network permissions or third-party runtime libraries.
- No scheduled background work.
- A minimal interface with a shortcut to system TTS settings.

## Install

Download the APK from [Releases](https://github.com/Zero-Dragon/silent-tts/releases), install it, and select **Silent TTS** as the preferred engine in Android's text-to-speech settings. You do not need to change your system language.

Android 8.0 (API 26) or newer is required. Package name: `local.silent.tts`.

The app contains only a short description and an **Open TTS settings** button. To restore speech, select another engine in system settings.

## Behavior and limitations

- Speech requests complete immediately without sound.
- Apps using their own speech engine or audio playback are unaffected.
- Apps that advance on completion may move through text rapidly.
- The Android service has normal process and IPC overhead; resource usage has not been benchmarked.
- Device compatibility is not comprehensively tested. If you encounter a problem, [open an issue](https://github.com/Zero-Dragon/silent-tts/issues) with your Android version, device model, and steps to reproduce it.

## Build

Use JDK 17 or newer, Android SDK Platform 36, and Gradle 8.13 (included wrapper). Set `ANDROID_HOME` to your Android SDK, or create an untracked `local.properties` with `sdk.dir`.

```sh
./gradlew assembleDebug
```

On Windows use `gradlew.bat assembleDebug`. The installable debug APK is written to `app/build/outputs/apk/debug/`. Android tooling creates a local debug key if needed.

`assembleRelease` produces an unsigned release APK. Sign it with your own key using Android's signing tools. Switching between builds signed with different keys requires uninstalling the existing app first.

## License

MIT. See [LICENSE](LICENSE).
