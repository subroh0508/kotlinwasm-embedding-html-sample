package net.subroh0508.kotlinwasm.embedding.html.sample.demo

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.WebElementView
import kotlinx.browser.document
import org.w3c.dom.HTMLIFrameElement

private const val SPOTIFY_SRC = "https://open.spotify.com/embed/track/1OXIKdTQNEsYY4Vc6lubjN?utm_source=generator"
private const val SPOTIFY_HEIGHT = 352

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Spotify(
    src: String = SPOTIFY_SRC,
    modifier: Modifier = Modifier,
) {
    WebElementView(
        factory = {
            (document.createElement("iframe") as HTMLIFrameElement).apply {
                this.src = src
                this.setAttribute("data-testid", "embed-iframe")
                this.setAttribute("frameborder", "0")
                this.allowFullscreen = true
                this.setAttribute("allow", "autoplay; clipboard-write; encrypted-media; fullscreen; picture-in-picture")
                this.setAttribute("loading", "lazy")
                this.style.apply {
                    borderRadius = "12px"
                    width = "100%"
                    height = "${SPOTIFY_HEIGHT}px"
                }
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .height(SPOTIFY_HEIGHT.dp),
        update = { iframe -> iframe.src = iframe.src }
    )
}