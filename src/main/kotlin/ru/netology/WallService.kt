package ru.netology

import java.time.LocalDateTime

object WallService {

    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {

        val newId = getMaxIdInPosts()

        posts += post.copy(id = newId)

        return posts.last()

    }

    fun update(post: Post): Boolean {

        for ((index, value) in posts.withIndex()) {

            if (post.id == value.id) {
                posts[index] = post.copy(ownerId = value.ownerId, date = value.date)
                return  true
            }

        }

        return  false

    }

    fun getMaxIdInPosts(): Int {

        var currentMaxId = 0

        for (value in posts) {
            if (value.id >= currentMaxId)  currentMaxId = value.id
        }

        return  currentMaxId + 1

    }



}