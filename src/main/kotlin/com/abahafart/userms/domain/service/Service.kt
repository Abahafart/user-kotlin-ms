package com.abahafart.userms.domain.service

import com.abahafart.userms.domain.model.Status

interface StatusService {
    fun create(status: Status): Status
    fun getById(id: String): Status
}