package ru.netology

import java.time.LocalDateTime

object WallService {

    private var posts = emptyArray<Post>()

    private var postId = 0

    fun newPost(text: String): Post {

        val comment = Comment(0, true,true, true, true)
        val copyright = Copyright(0, "", "", "")
        val like = Like(0, false, true, true)
        val repost = Repost(0, false)
        val view = View(0)
        val donut = Donut(false, 0, "", true, "")
        val nowDate = LocalDateTime.now()
        val nowDateUnixtime = System.currentTimeMillis() / 1000L;  //(TimeZone.getTimeZone("Europe/Moscow"))

        val result = Post(
            postId,
            0,
            0,
            0,
            nowDateUnixtime.toInt(),
            text,
            0,
            0,
            false,
            comment,
            copyright,
            like,
            repost,
            view,
            0,
            0,
            true,
            true,
            true,
            false,
            false,
            false,
            donut,
            0)

        postId = postId + 1

        return result;

    }


    fun add(post: Post): Post {

        posts+=post

        return posts.last()

    }

    fun update(post: Post): Boolean {

        for ((index, value) in posts.withIndex()) {

            if (post.id == value.id) {
                posts[index] = post.copy(id = value.id, date = value.date)
                return  true
            }

        }

        return  false

    }

}