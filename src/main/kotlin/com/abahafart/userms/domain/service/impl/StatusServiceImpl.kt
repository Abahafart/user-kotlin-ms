package com.abahafart.userms.domain.service.impl

import com.abahafart.userms.domain.model.StatusDO
import com.abahafart.userms.domain.repository.StatusRepository
import com.abahafart.userms.domain.service.StatusService
import org.springframework.stereotype.Service

@Service
class StatusServiceImpl(val statusRepository: StatusRepository): StatusService {
    override fun create(statusDO: StatusDO) = statusRepository.saveStatus(statusDO)
    override fun getById(id: String) = statusRepository.getById(id)
}