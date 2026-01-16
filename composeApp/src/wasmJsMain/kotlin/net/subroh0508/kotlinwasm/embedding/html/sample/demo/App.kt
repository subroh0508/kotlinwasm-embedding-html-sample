package net.subroh0508.kotlinwasm.embedding.html.sample.demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private enum class EmbedContent(val label: String) {
    OPEN_STREET_MAP("OpenStreetMap"),
    SPEAKER_DECK("SpeakerDeck"),
    SPOTIFY("Spotify"),
}

@Composable
fun App() {
    var selectedIndex by remember { mutableIntStateOf(0) }

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
            ) {
                PrimaryTabRow(selectedTabIndex = selectedIndex) {
                    EmbedContent.entries.forEachIndexed { index, content ->
                        Tab(
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index },
                            text = { Text(content.label) },
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(16.dp),
                ) {
                    when (EmbedContent.entries[selectedIndex]) {
                        EmbedContent.OPEN_STREET_MAP -> OpenStreetMap()
                        EmbedContent.SPEAKER_DECK -> SpeakerDeck()
                        EmbedContent.SPOTIFY -> Spotify()
                    }
                }
            }
        }
    }
}
