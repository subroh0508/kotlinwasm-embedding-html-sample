# Kotlin/Wasm Embedding HTML Sample

[Compose Multiplatform for Web v1.9.0](https://github.com/JetBrains/compose-multiplatform/releases/tag/v1.9.0)で追加された`WebElementView`関数のデモ用Webアプリです。

## デモ内容

以下の埋め込みコンテンツをドロップダウンメニューで切り替えて表示できます：

- **OpenStreetMap** - 地図の埋め込み
- **SpeakerDeck** - スライドの埋め込み
- **Spotify** - 音楽プレイヤーの埋め込み

## ビルド & 実行

### 開発用（Development）

**macOS / Linux:**
```shell
./gradlew :composeApp:wasmJsBrowserDevelopmentRun
```

**Windows:**
```shell
.\gradlew.bat :composeApp:wasmJsBrowserDevelopmentRun
```

### 本番用（Production）

**macOS / Linux:**
```shell
./gradlew :composeApp:wasmJsBrowserDistribution
```

**Windows:**
```shell
.\gradlew.bat :composeApp:wasmJsBrowserDistribution
```

ビルド成果物は `composeApp/build/dist/wasmJs/productionExecutable/` に出力されます。

## 参考文献

- [What's new in Compose Multiplatform 1.9.0 - New API for embedding HTML content](https://kotlinlang.org/docs/multiplatform/whats-new-compose-190.html#new-api-for-embedding-html-content)
- [Compose Multiplatform v1.9.0 Release Notes](https://github.com/JetBrains/compose-multiplatform/releases/tag/v1.9.0)
- [CMP-8521: Web: Impossible to overlay Compose UI elements on WebElementView](https://youtrack.jetbrains.com/issue/CMP-8521/Web-Impossible-to-overlay-Compose-UI-elements-on-WebElementView)
- [compose-multiplatform-core PR #2153: nested compose viewport demo](https://github.com/JetBrains/compose-multiplatform-core/pull/2153)
