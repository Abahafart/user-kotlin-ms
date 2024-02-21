package com.abahafart.userms.infra.controller.response

import java.time.Instant

data class StatusResponse(val id: String, val description: String, val type: String, val createdAt: Instant)