package ru.netology

import org.junit.Test

import org.junit.Assert.*

internal class WallServiceTest {

    @Test
    fun testAdd() {

        val post: Post = WallService.newPost("Первый пост")
        WallService.add(post)
        assertNotEquals(post.id, 0)
    }

    @Test
    fun testUpdateWhithId() {

        val post: Post = WallService.newPost("Первый пост")
        WallService.add(post)
        val result: Boolean = WallService.update(post)

        assertEquals(result, true)
    }

    @Test
    fun testUpdateNotId() {
        val post: Post = WallService.newPost("Первый пост")
        val result: Boolean = WallService.update(post.copy(id = -1))

        assertEquals(result, false)
    }

}