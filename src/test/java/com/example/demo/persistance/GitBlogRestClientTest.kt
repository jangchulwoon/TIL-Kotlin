package com.example.demo.persistance

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class GitBlogRestClientTest(private val gitBlogRestClient: GitBlogRestClient) {
    companion object {
        val log = LoggerFactory.getLogger(this::class.java)
    }

    @Test
    fun getBlogBody() {
        val body: String = gitBlogRestClient.getBlogHome()

        log.info(body)
        assertTrue(body.isNotEmpty())
    }

}