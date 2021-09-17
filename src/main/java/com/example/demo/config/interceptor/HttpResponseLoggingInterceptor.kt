package com.example.demo.config.interceptor

import org.apache.commons.io.IOUtils
import org.slf4j.LoggerFactory
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import kotlin.text.Charsets.UTF_8


class HttpResponseLoggingInterceptor : ClientHttpRequestInterceptor {
    companion object {
        val log = LoggerFactory.getLogger(this::class.java)
    }

    override fun intercept(request: HttpRequest, body: ByteArray, execution: ClientHttpRequestExecution): ClientHttpResponse {
        if (body.isNotEmpty()) {
            log.info("request Body : $body")
        }

        val response = execution.execute(request, body)

        log.info("response Header : ${response.headers}")
        log.info("response body : ${IOUtils.toString(response.body, UTF_8)}")

        return response
    }
}