package com.abahafart.userms.infra.repository.impl

import com.abahafart.userms.domain.exceptions.ResourceNotFound
import com.abahafart.userms.domain.model.StatusDO
import com.abahafart.userms.domain.repository.StatusRepository
import com.abahafart.userms.infra.repository.StatusMongoRepository
import com.abahafart.userms.infra.repository.document.StatusDocument
import org.springframework.stereotype.Repository

@Repository
class StatusRepositoryImpl(val statusMongoRepository: StatusMongoRepository): StatusRepository {
    override fun saveStatus(statusDO: StatusDO): StatusDO {
        val statusDocument = StatusDocument(description = statusDO.description, type = statusDO.type)
        return buildModel(statusMongoRepository.save(statusDocument))
    }

    override fun getById(id: String): StatusDO {
        return statusMongoRepository.findById(id).orElseThrow { ResourceNotFound("status with id $id not found") }
            .let { buildModel(it) }
    }

    fun buildModel(document: StatusDocument): StatusDO {
        return StatusDO(document.id.toString(), document.description, document.type, document.createdAt)
    }

}