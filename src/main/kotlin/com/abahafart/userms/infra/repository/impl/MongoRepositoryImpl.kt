package com.abahafart.userms.infra.repository.impl

import com.abahafart.userms.domain.model.Status
import com.abahafart.userms.domain.repository.StatusRepository
import com.abahafart.userms.infra.repository.StatusMongoRepository
import com.abahafart.userms.infra.repository.document.StatusDocument
import org.springframework.stereotype.Repository

@Repository
class StatusRepositoryImpl(val statusMongoRepository: StatusMongoRepository): StatusRepository {
    override fun saveStatus(status: Status): Status {
        val statusDocument = StatusDocument(description = status.description, type = status.type)
        return statusMongoRepository.save(statusDocument).let { Status(id = it.id.toString(),
            description = it.description, type = it.type, createdAt = it.createdAt) }
    }

    override fun getById(id: String): Status {
        TODO("Not yet implemented")
    }

}