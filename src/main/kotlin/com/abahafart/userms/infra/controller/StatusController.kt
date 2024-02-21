package com.abahafart.userms.infra.controller

import com.abahafart.userms.domain.model.Status
import com.abahafart.userms.domain.service.StatusService
import com.abahafart.userms.infra.controller.request.StatusRequest
import com.abahafart.userms.infra.controller.response.StatusResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/status")
class StatusController(val statusService: StatusService) {

    @PostMapping
    fun createStatus(@RequestBody request: StatusRequest): StatusResponse {
        val statusModel = Status(description = request.description, type = request.type)
        val statusResponse = statusService.create(statusModel)
        return StatusResponse(statusResponse.id, statusResponse.description, statusResponse.type, statusResponse.createdAt)
    }
}
