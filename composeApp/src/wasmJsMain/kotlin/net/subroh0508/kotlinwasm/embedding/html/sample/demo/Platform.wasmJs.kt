package net.subroh0508.kotlinwasm.embedding.html.sample.demo

class WasmPlatform : Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()
