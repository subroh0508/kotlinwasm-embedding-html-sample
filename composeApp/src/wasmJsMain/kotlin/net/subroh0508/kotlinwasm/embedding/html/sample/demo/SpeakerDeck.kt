package net.subroh0508.kotlinwasm.embedding.html.sample.demo

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.WebElementView
import kotlinx.browser.document
import org.w3c.dom.HTMLIFrameElement

private const val SPEAKERDECK_SRC = "https://speakerdeck.com/player/60ea30fcfad241239cba1b136736fc20"
private const val SPEAKERDECK_TITLE = "MustをWillに変える技術 〜アイドル・郁田はるきが\"すべき\"の壁を超えるまで〜"

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SpeakerDeck(
    src: String = SPEAKERDECK_SRC,
    title: String = SPEAKERDECK_TITLE,
    modifier: Modifier = Modifier,
) {
    WebElementView(
        factory = {
            (document.createElement("iframe") as HTMLIFrameElement).apply {
                this.src = src
                this.title = title
                this.className = "speakerdeck-iframe"
                this.allowFullscreen = true
                this.setAttribute("frameborder", "0")
                this.style.apply {
                    border = "0px"
                    background = "padding-box padding-box rgba(0, 0, 0, 0.1)"
                    margin = "0px"
                    padding = "0px"
                    borderRadius = "6px"
                    boxShadow = "rgba(0, 0, 0, 0.2) 0px 5px 40px"
                    width = "100%"
                    height = "auto"
                    setProperty("aspect-ratio", "560 / 315")
                }
                this.setAttribute("data-ratio", "1.7777777777777777")
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f),
        update = { iframe -> iframe.src = iframe.src }
    )
}
