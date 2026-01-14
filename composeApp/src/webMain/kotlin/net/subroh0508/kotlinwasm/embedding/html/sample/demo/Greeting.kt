package net.subroh0508.kotlinwasm.embedding.html.sample.demo

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}