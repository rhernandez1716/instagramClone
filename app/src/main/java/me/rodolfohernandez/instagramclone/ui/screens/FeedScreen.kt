package me.rodolfohernandez.instagramclone.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.rodolfohernandez.instagramclone.data.DataSource
import me.rodolfohernandez.instagramclone.ui.components.PostCard
import me.rodolfohernandez.instagramclone.ui.components.StoriesRow

@Composable
fun FeedScreen() {
    val posts = remember { DataSource.getPosts() }
    val stories = remember { DataSource.getStories() }

    Scaffold(
        topBar = { InstagramTopBar() }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            state = rememberLazyListState()
        ) {

            /* ── Las stories van como un item único dentro del LazyColumn ── */
            item(key = "stories_row") {
                StoriesRow(stories = stories)
                HorizontalDivider()
            }

            /* ── Los posts se iteran con items ── */
            items(
                items = posts,
                key = { post -> post.id }
            ) { post ->
                PostCard(
                    post = post,
                    onLikeClick = { likedPost ->
                        // reto avanzado 07
                        Log.d("Feed", "Like en: ${likedPost.username}")
                    }
                )
            }

            // reto 07: texto al final del feed
            item(key = "fin_feed") {
                Text(
                    text = "Has llegado al final 🎉",
                    modifier = Modifier.fillMaxWidth().padding(24.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

/* ── TOP BAR estilo Instagram ── */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Instagram",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                fontFamily = FontFamily.Cursive
            )
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.FavoriteBorder, "Notificaciones")
            }
            IconButton(onClick = {}) {
                Icon(Icons.Outlined.Send, "Mensajes")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}