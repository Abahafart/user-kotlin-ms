package com.abahafart.userms

import com.abahafart.userms.infra.service.TvProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(TvProperties::class)
class UserLibraryKotlinMsApplication

fun main(args: Array<String>) {
    runApplication<UserLibraryKotlinMsApplication>(*args)
}
