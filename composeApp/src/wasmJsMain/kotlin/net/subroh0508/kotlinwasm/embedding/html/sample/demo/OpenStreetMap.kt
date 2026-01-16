package net.subroh0508.kotlinwasm.embedding.html.sample.demo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.WebElementView
import kotlinx.browser.document
import org.w3c.dom.HTMLIFrameElement

private const val OSM_URL = "https://www.openstreetmap.org/export/embed.html?bbox=4.890965223312379%2C52.33722052818563%2C4.893990755081177%2C52.33860862450587&layer=mapnik"

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OpenStreetMap(modifier: Modifier = Modifier) {
    WebElementView(
        factory = {
            (document.createElement("iframe") as HTMLIFrameElement)
                .apply { src = OSM_URL }
        },
        modifier = modifier.fillMaxSize(),
        update = { iframe -> iframe.src = iframe.src }
    )
}
