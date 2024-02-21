package com.abahafart.userms.domain.model

import java.time.Instant

data class Status(var id: String = "", var description: String, var type: String, var createdAt: Instant = Instant.now())