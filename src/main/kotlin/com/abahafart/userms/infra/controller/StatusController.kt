package com.abahafart.userms.infra.controller

import com.abahafart.userms.domain.model.Status
import com.abahafart.userms.domain.service.StatusService
import com.abahafart.userms.infra.controller.request.StatusRequest
import com.abahafart.userms.infra.controller.response.StatusResponse
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/status")
class StatusController(val statusService: StatusService) {

    private val logger = KotlinLogging.logger {}

    @PostMapping
    fun createStatus(@RequestBody request: StatusRequest): StatusResponse {
        val statusModel = Status(description = request.description, type = request.type)
        val statusResponse = statusService.create(statusModel)
        return buildResponse(statusResponse)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String): StatusResponse {
        logger.info { "id $id received" }
        return buildResponse(statusService.getById(id))
    }

    fun buildResponse(status: Status): StatusResponse {
        return StatusResponse(status.id, status.description, status.type, status.createdAt)
    }
}
