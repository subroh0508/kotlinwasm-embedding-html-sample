package net.subroh0508.kotlinwasm.embedding.html.sample.demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform