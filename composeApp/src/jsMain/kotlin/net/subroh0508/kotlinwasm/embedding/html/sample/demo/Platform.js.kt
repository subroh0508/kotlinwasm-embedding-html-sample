package net.subroh0508.kotlinwasm.embedding.html.sample.demo

class JsPlatform : Platform {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getPlatform(): Platform = JsPlatform()
