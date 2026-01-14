package net.subroh0508.kotlinwasm.embedding.html.sample.demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import kotlinx.browser.document
import androidx.compose.ui.viewinterop.WebElementView
import org.w3c.dom.HTMLIFrameElement

private const val OSM_URL = "https://www.openstreetmap.org/export/embed.html?bbox=4.890965223312379%2C52.33722052818563%2C4.893990755081177%2C52.33860862450587&layer=mapnik"

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App() {
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight()
        ) {
            WebElementView(
                factory = {
                    (document.createElement("iframe") as HTMLIFrameElement)
                        .apply { src = OSM_URL }
                },
                modifier = Modifier.fillMaxSize(),
                update = { iframe -> iframe.src = iframe.src }
            )
        }
    }
}
