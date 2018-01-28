package com.smartinrub.trainingtodocoreservice.controllers

import com.smartinrub.trainingtodocoreservice.App
import com.smartinrub.trainingtodocoreservice.models.Item
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test


import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(App::class),
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerTest {

    @Autowired
    lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun findAll() {
        val result = testRestTemplate.getForEntity("/", String::class.java)
        assertNotNull(result)
        assertEquals(result?.statusCode, HttpStatus.OK)
        assertThat(result?.body, containsString("Bananas"))
    }

    @Test
    fun findByName() {
        val result = testRestTemplate.getForEntity("/apple", String::class.java)
        assertNotNull(result)
        assertEquals(result?.statusCode, HttpStatus.OK)
        assertEquals(result?.body, "[{\"id\":1,\"name\":\"apple\"}]")
    }

    @Test
    fun addItem() {
        val item = Item(5, "test")
        val result1 = testRestTemplate.postForEntity("/", item, Item::class.java)
        assertNotNull(result1)
        assertEquals(result1?.statusCode, HttpStatus.OK)
        val result2 = testRestTemplate.getForEntity("/test", String::class.java)
        assertThat(result2?.body, containsString("test"))
    }

    @Test
    fun deleteItemById() {
        val result = testRestTemplate.delete("/5")
        assertNotNull(result)
    }
}