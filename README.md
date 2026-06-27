# 🎹 PianoKu - Piano Learning App

PianoKu adalah aplikasi Android modern untuk belajar piano dengan cara yang fun dan interaktif! Dibangun dengan **Kotlin + Jetpack Compose** dan mendukung **Android 13+**.

## ✨ Fitur Utama

### 🎵 Keyboard Piano
- Piano keyboard 25 keys interaktif
- Synthesizer audio real-time
- Dukungan white keys dan black keys
- Feedback visual saat menekan key

### 📚 Lessons (Pelajaran)
- Pelajaran terstruktur dari beginner hingga master
- 5 level kesulitan
- Deskripsi lengkap untuk setiap lesson
- Tracking progress learning

### 🎮 Games (Mini Games)
- **Note Recognition** - Identifikasi nada berdasarkan suara
- **Piano Tiles** - Ketuk key sesuai urutan
- **Melody Master** - Recreate melodies
- **Chord Challenge** - Mainkan chord yang benar

### 🎙️ Recording
- Rekam performa Anda
- Simpan dan putar ulang
- Delete recordings yang tidak diinginkan

### ⏱️ Metronome
- Adjustable BPM (40-200)
- Tick sound visual feedback
- Perfect untuk practice

### ⚙️ Settings
- Kontrol volume audio
- Pilih level kesulitan default
- Tema dan preferensi

## 🛠️ Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Audio**: Android MediaPlayer + AudioTrack
- **Architecture**: MVVM dengan StateFlow
- **Navigation**: Jetpack Navigation Compose
- **Storage**: DataStore Preferences
- **Min SDK**: Android 13 (API 33)
- **Target SDK**: Android 14 (API 34)

## 📦 Dependencies

```gradle
// Core
androidx.core:core-ktx:1.12.0
androidx.lifecycle:lifecycle-runtime-ktx:2.6.2

// Jetpack Compose
androidx.compose.ui:ui
androidx.compose.material3:material3:1.1.1
androidx.navigation:navigation-compose:2.7.5

// Audio
androidx.media:media:1.6.0
kotlinx.coroutines:kotlinx-coroutines-android:1.7.3

// Data
androidx.datastore:datastore-preferences:1.0.0
```

## 🚀 Getting Started

### Prerequisites
- Android Studio Flamingo atau lebih baru
- JDK 17+
- Android SDK 34

### Installation

1. Clone repository:
```bash
git clone https://github.com/donysept/Testing-Piano-App.git
cd Testing-Piano-App
```

2. Open di Android Studio dan tunggu gradle sync

3. Run di emulator atau device:
```bash
./gradlew installDebug
```

## 📁 Project Structure

```
app/src/main/
├── java/com/pianoapp/pianoku/
│   ├── MainActivity.kt
│   ├── AudioSynthesizer.kt
│   ├── RecordingManager.kt
│   ├── LessonManager.kt
│   ├── GameManager.kt
│   ├── MetronomeManager.kt
│   ├── PianoViewModel.kt
│   ├── LessonViewModel.kt
│   ├── GameViewModel.kt
│   ├── RecordingViewModel.kt
│   └── ui/
│       ├── HomeScreen.kt
│       ├── PianoKeyboard.kt
│       ├── LessonScreen.kt
│       ├── GameScreen.kt
│       └── MetronomeScreen.kt
├── res/
│   ├── values/
│   │   ├── strings.xml
│   │   ├── colors.xml
│   │   ├── themes.xml
│   │   └── arrays.xml
│   └── xml/
│       └── preferences.xml
└── AndroidManifest.xml
```

## 🎯 Roadmap

- [ ] Integrasi YouTube untuk video lessons
- [ ] Cloud sync untuk progress
- [ ] Multiplayer challenges
- [ ] MIDI controller support
- [ ] Custom recording editor
- [ ] Offline mode
- [ ] Analytics & stats

## 🤝 Contributing

See [CONTRIBUTING.md](CONTRIBUTING.md) untuk panduan kontribusi.

## 📄 License

Project ini licensed di bawah MIT License - lihat [LICENSE](LICENSE) file.

## 👨‍💻 Author

**Dony Septyharsono**
- GitHub: [@donysept](https://github.com/donysept)
- Email: donyseptyharsono@gmail.com

## 📞 Support

Jika punya pertanyaan atau issue, buka [GitHub Issues](https://github.com/donysept/Testing-Piano-App/issues).

---

**Happy Learning! 🎹✨**
