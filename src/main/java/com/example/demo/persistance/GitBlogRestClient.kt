package com.example.demo.persistance

import com.example.demo.config.GitBlogRestTemplateConfig
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Component
class GitBlogRestClient(val gitBlogRestTemplate: RestTemplate) {


    fun getBlogHome(): String {
        val uri: URI = UriComponentsBuilder.fromHttpUrl("https://jangchulwoon.github.io/")
                .build()
                .toUri()

        return gitBlogRestTemplate.getForEntity(uri, String::class.java).body
    }

}