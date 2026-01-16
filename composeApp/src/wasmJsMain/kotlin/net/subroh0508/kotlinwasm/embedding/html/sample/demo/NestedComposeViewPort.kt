package net.subroh0508.kotlinwasm.embedding.html.sample.demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.WebElementView
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLDivElement

/**
 * Compose UI要素がWebElementViewの上に重ねて表示できない問題の回避策。
 *
 * WebElementView内にネストされたComposeViewportを作成し、
 * ドロップダウンメニューなどのCompose UI要素を埋め込みHTMLコンテンツの上に
 * 描画できるようにする。
 *
 * 問題: https://youtrack.jetbrains.com/issue/CMP-8521/Web-Impossible-to-overlay-Compose-UI-elements-on-WebElementView
 * 参考: https://github.com/JetBrains/compose-multiplatform-core/pull/2153
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NestedComposeViewPort(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    WebElementView(
        factory = {
            (document.createElement("div") as HTMLDivElement).apply {
                style.background = "transparent"

                window.requestAnimationFrame {
                    ComposeViewport(this) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .drawBehind {
                                    drawRect(
                                        color = Color.Transparent,
                                        blendMode = BlendMode.Clear,
                                    )
                                },
                        ) {
                            content()
                        }
                    }
                }
            }
        },
        modifier = modifier.fillMaxSize(),
        update = {},
    )
}