package com.abahafart.userms.domain.service

import com.abahafart.userms.domain.model.StatusDO

interface StatusService {
    fun create(statusDO: StatusDO): StatusDO
    fun getById(id: String): StatusDO
}