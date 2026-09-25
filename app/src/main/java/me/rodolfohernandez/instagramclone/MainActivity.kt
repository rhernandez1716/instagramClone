package me.rodolfohernandez.instagramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.rodolfohernandez.instagramclone.data.DataSource
import me.rodolfohernandez.instagramclone.model.Post
import me.rodolfohernandez.instagramclone.ui.components.BasicFeedList
import me.rodolfohernandez.instagramclone.ui.screens.FeedScreen
import me.rodolfohernandez.instagramclone.ui.theme.InstagramCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ejercicio 01.2: objeto de prueba
        val post = Post(
            id = 1,
            username = "yo",
            profileImageUrl = "",
            imageUrl = "",
            likes = 10,
            caption = "Mi primer post"
        )
        println(post)

        // Ejercicio 01.3 (Reto): copia con isLiked = true
        val postLiked = post.copy(isLiked = true)
        println(postLiked)

        enableEdgeToEdge()
        setContent {
            InstagramCloneTheme {
                FeedScreen()
                //BasicFeedList(posts = DataSource.getPosts())
            }
            }
        }
    }

