# PianoKu PWA - Progressive Web App Version

🎹 **Learn Piano Anywhere, Anytime!**

PianoKu PWA adalah versi web dari aplikasi PianoKu yang bisa diakses langsung dari browser di laptop atau smartphone tanpa perlu install aplikasi Android.

## ✨ Fitur

### 🎵 Piano Keyboard
- Interactive 25-key piano keyboard
- Web Audio API untuk sound synthesis
- Real-time feedback visual
- Responsive design

### 📚 Lessons
- 5 pelajaran terstruktur (Beginner → Master)
- Level-based progression
- Easy to follow content

### 🎮 Games
- Note Recognition - Identifikasi nada
- Piano Tiles - Tap sequence game
- Melody Master - Recreate melodies
- Chord Challenge - Play correct chords

### ⏱️ Metronome
- BPM range: 40-200
- Real-time click sound
- Perfect untuk practice

### 📱 PWA Features
- **Offline Support** - Bekerja tanpa internet
- **Installable** - Bisa di-install seperti native app
- **Responsive** - Desktop, tablet, mobile
- **Fast Loading** - Service Worker caching

## 🚀 Getting Started

### Prerequisites
- Node.js 18+ ([Download](https://nodejs.org/))
- npm atau yarn
- Browser modern (Chrome, Firefox, Safari, Edge)

### Installation

```bash
# Clone repository
git clone https://github.com/donysept/Testing-Piano-App.git
cd Testing-Piano-App/pwa

# Install dependencies
npm install

# Development server
npm run dev

# Build untuk production
npm run build

# Preview production build
npm run preview
```

## 🌐 Opening PWA

### Di Browser Desktop
1. Buka http://localhost:5173
2. Klik ikon install di address bar
3. Atau buka DevTools (F12) → Application → Install button

### Di Smartphone
1. Buka di Chrome/Safari
2. Tap menu (⋮) → "Install app"
3. atau tap share icon → "Add to Home Screen"

## 📁 Project Structure

```
pwa/
├── public/
│   ├── manifest.json          # PWA manifest
│   └── service-worker.js      # Offline support
├── src/
│   ├── components/
│   │   ├── Navigation.tsx      # Nav bar
│   │   └── Navigation.css
│   ├── pages/
│   │   ├── HomePage.tsx        # Home screen
│   │   ├── PianoPage.tsx       # Piano keyboard
│   │   ├── LessonsPage.tsx     # Lessons list
│   │   ├── GamesPage.tsx       # Games list
│   │   └── MetronomePage.tsx   # Metronome
│   ├── styles/
│   │   └── pages.css           # Page styles
│   ├── App.tsx                 # Main app
│   ├── App.css                 # App styles
│   ├── main.tsx                # Entry point
│   └── index.css               # Global styles
├── index.html                  # HTML template
├── vite.config.ts              # Vite config
├── tsconfig.json               # TypeScript config
└── package.json                # Dependencies
```

## 🛠️ Tech Stack

- **Framework:** React 18 + TypeScript
- **Build Tool:** Vite
- **Audio:** Web Audio API
- **Offline:** Service Workers
- **Styling:** CSS3 with CSS Variables
- **Package Manager:** npm

## 📦 Dependencies

```json
{
  "dependencies": {
    "react": "^18.2.0",
    "react-dom": "^18.2.0"
  },
  "devDependencies": {
    "@types/react": "^18.2.0",
    "@types/react-dom": "^18.2.0",
    "@vitejs/plugin-react": "^4.0.0",
    "typescript": "^5.0.0",
    "vite": "^5.0.0"
  }
}
```

## 🌙 Dark Theme

PWA menggunakan modern dark theme:
- Primary: `#6200ee` (Purple)
- Accent: `#03dac6` (Cyan)
- Background: `#121212` (Dark)
- Surface: `#1e1e1e` (Surface)

## 📱 Browser Support

✅ Chrome 90+  
✅ Firefox 88+  
✅ Safari 14+  
✅ Edge 90+  
✅ Mobile browsers  

## 🔒 Privacy & Security

- ✅ Offline-first architecture
- ✅ No external API calls (kecuali optional)
- ✅ Data stored locally
- ✅ No tracking/analytics
- ✅ HTTPS ready

## 📝 Available Scripts

```bash
# Development
npm run dev          # Start dev server
npm run build        # Build for production
npm run preview      # Preview production build
npm run type-check   # TypeScript type checking
```

## 🚀 Deployment

### Deploy ke GitHub Pages

```bash
# Build
npm run build

# Push dist folder ke gh-pages branch
git subtree push --prefix pwa/dist origin gh-pages
```

### Deploy ke Netlify

```bash
# Connect repo ke Netlify
# Build command: npm run build
# Publish directory: pwa/dist
```

### Deploy ke Vercel

```bash
# Connect repo ke Vercel
# Framework: Vite
# Build: npm run build
```

## 🐛 Troubleshooting

### Service Worker tidak ter-register?
- Buka DevTools → Application → Service Workers
- Pastikan browser support PWA
- Clear cache & refresh halaman

### Audio tidak jalan?
- Check browser console untuk errors
- Pastikan speaker/headset terkoneksi
- Refresh halaman

### Install button tidak muncul?
- PWA harus serve dari HTTPS (production)
- Manifest.json harus valid
- Icons harus tersedia

## 📚 Resources

- [Web Audio API](https://developer.mozilla.org/en-US/docs/Web/API/Web_Audio_API)
- [Service Workers](https://developer.mozilla.org/en-US/docs/Web/API/Service_Worker_API)
- [PWA Documentation](https://web.dev/progressive-web-apps/)
- [React Docs](https://react.dev)

## 🤝 Contributing

Lihat [CONTRIBUTING.md](../CONTRIBUTING.md) untuk panduan kontribusi.

## 📄 License

MIT License - lihat [LICENSE](../LICENSE)

## 👨‍💻 Author

**Dony Septyharsono**
- GitHub: [@donysept](https://github.com/donysept)
- Email: donyseptyharsono@gmail.com

---

**Enjoy Learning Piano! 🎹✨**
