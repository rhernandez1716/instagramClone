package me.rodolfohernandez.instagramclone.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.rodolfohernandez.instagramclone.model.Post

// Ejemplo básico de LazyColumn
@Composable
fun BasicFeedList(posts: List<Post>) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Reto 02.3: item antes de los posts
        item {
            Text("— Inicio del Feed —")
        }

        // items() itera sobre la lista de forma lazy
        items(
            items = posts,
            key = { post -> post.id }
        ) { post ->
            PostCard(post = post)
        }
    }
}

// Variante con índice
@Composable
fun FeedWithIndex(posts: List<Post>) {
    LazyColumn {
        itemsIndexed(posts) { index, post ->
            Text("Post #$index: ${post.username}")
        }
    }
}