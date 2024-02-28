package com.abahafart.userms.infra.controller

import com.abahafart.userms.domain.model.CountryDO
import com.abahafart.userms.domain.service.CountryService
import com.abahafart.userms.infra.controller.request.CountryRequest
import com.abahafart.userms.infra.controller.response.CountryResponse
import mu.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/countries")
class CountryController(val countryService: CountryService) {

    private val logger = KotlinLogging.logger {  }

    @PostMapping
    fun saveCountry(@RequestBody countryRequest: CountryRequest): CountryResponse {
        logger.info { "information received $countryRequest" }
        return buildResponse(countryService.create(buildDO(countryRequest)))
    }

    private fun buildResponse(countryDO: CountryDO): CountryResponse {
        return CountryResponse(id = countryDO.id, name = countryDO.name,
            description = countryDO.description, shortVersion = countryDO.shortVersion,
            createdAt = countryDO.createdAt)
    }

    private fun buildDO(countryRequest: CountryRequest): CountryDO {
        return CountryDO(name = countryRequest.name, description = countryRequest.description,
            shortVersion = countryRequest.shortVersion)
    }
}