package com.abahafart.userms.domain.service.impl

import com.abahafart.userms.domain.model.Status
import com.abahafart.userms.domain.repository.StatusRepository
import com.abahafart.userms.domain.service.StatusService
import org.springframework.stereotype.Service

@Service
class StatusServiceImpl(val statusRepository: StatusRepository): StatusService {
    override fun create(status: Status) = statusRepository.saveStatus(status)
    override fun getById(id: String): Status {
        TODO("Not yet implemented")
    }
}