package com.abahafart.userms.infra.controller

import com.abahafart.userms.domain.model.StatusDO
import com.abahafart.userms.domain.service.StatusService
import com.abahafart.userms.infra.controller.request.StatusRequest
import com.abahafart.userms.infra.controller.response.StatusResponse
import com.abahafart.userms.infra.service.GetAuthentication
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/status")
class StatusController(val statusService: StatusService, val moviesConnection: GetAuthentication) {

    private val logger = KotlinLogging.logger {}

    @PostMapping
    fun createStatus(@RequestBody request: StatusRequest): StatusResponse {
        val statusDOModel = StatusDO(description = request.description, type = request.type)
        val statusResponse = statusService.create(statusDOModel)
        return buildResponse(statusResponse)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): StatusResponse {
        logger.info { "id $id received" }
        moviesConnection.authenticate()
        return buildResponse(statusService.getById(id))
    }

    fun buildResponse(statusDO: StatusDO): StatusResponse {
        return StatusResponse(statusDO.id, statusDO.description, statusDO.type, statusDO.createdAt)
    }
}
