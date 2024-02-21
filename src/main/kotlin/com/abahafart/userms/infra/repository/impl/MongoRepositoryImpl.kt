package com.abahafart.userms.infra.repository.impl

import com.abahafart.userms.domain.exceptions.ResourceNotFound
import com.abahafart.userms.domain.model.Status
import com.abahafart.userms.domain.repository.StatusRepository
import com.abahafart.userms.infra.repository.StatusMongoRepository
import com.abahafart.userms.infra.repository.document.StatusDocument
import org.springframework.stereotype.Repository

@Repository
class StatusRepositoryImpl(val statusMongoRepository: StatusMongoRepository): StatusRepository {
    override fun saveStatus(status: Status): Status {
        val statusDocument = StatusDocument(description = status.description, type = status.type)
        return buildModel(statusMongoRepository.save(statusDocument))
    }

    override fun getById(id: String): Status {
        return statusMongoRepository.findById(id).orElseThrow { ResourceNotFound("status with id $id not found") }
            .let { buildModel(it) }
    }

    fun buildModel(document: StatusDocument): Status {
        return Status(document.id.toString(), document.description, document.type, document.createdAt)
    }

}