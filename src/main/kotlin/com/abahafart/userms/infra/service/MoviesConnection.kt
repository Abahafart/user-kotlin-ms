package com.abahafart.userms.infra.service

import mu.KotlinLogging
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service

@Configuration
@ConfigurationProperties(prefix = "tv")
class TvProperties {
    lateinit var token: String
    lateinit var url: String
}

interface GetAuthentication {
    fun authenticate(): String
}

@Service
class MoviesConnection(val restTemplateBuilder: RestTemplateBuilder, val tvProperties: TvProperties): GetAuthentication {
    val restTemplate = restTemplateBuilder.build()

    private val log = KotlinLogging.logger {}
    override fun authenticate(): String {
        val httpHeaders = HttpHeaders()
        httpHeaders.add("accept", "application/json")
        httpHeaders.add("Authorization", "Bearer ${tvProperties.token}")
        val httpEntity = HttpEntity<String>(httpHeaders)
        val response = restTemplate.exchange(tvProperties.url, HttpMethod.GET, httpEntity, TvAuthentication::class.java)
        log.info { "Response from authentication ${response.body}" }
        return ""
    }
}

data class TvAuthentication(val success: Boolean, val status_code: Int, val status_message: String)