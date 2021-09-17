package com.example.demo.config

import com.example.demo.config.interceptor.HttpResponseLoggingInterceptor
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.BufferingClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Configuration
open class GitBlogRestTemplateConfig {

    @Bean
    open fun gitBlogRestTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate = restTemplateBuilder
            .requestFactory { BufferingClientHttpRequestFactory(SimpleClientHttpRequestFactory()) }
            .additionalInterceptors(listOf(HttpResponseLoggingInterceptor()))
            .build()

}