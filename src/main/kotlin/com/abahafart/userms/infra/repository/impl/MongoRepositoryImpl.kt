package com.abahafart.userms.infra.repository.impl

import com.abahafart.userms.domain.exceptions.ResourceNotFound
import com.abahafart.userms.domain.model.CountryDO
import com.abahafart.userms.domain.model.StatusDO
import com.abahafart.userms.domain.repository.CountryRepository
import com.abahafart.userms.domain.repository.StatusRepository
import com.abahafart.userms.infra.repository.CountryMongoRepository
import com.abahafart.userms.infra.repository.StatusMongoRepository
import com.abahafart.userms.infra.repository.document.CountryDocument
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

@Repository
class CountryRepositoryImpl(val countryMongoRepository: CountryMongoRepository): CountryRepository {
    override fun saveCountry(countryDO: CountryDO): CountryDO {
        val countryDocument = CountryDocument(name = countryDO.name, description = countryDO.description,
            shortVersion = countryDO.shortVersion)
        return buildCountryDocument(countryMongoRepository.save(countryDocument))
    }

    override fun getById(id: String): CountryDO {
        return countryMongoRepository.findById(id).orElseThrow { ResourceNotFound("country with id $id not found") }
            .let { buildCountryDocument(it) }
    }

    override fun getByName(name: String): CountryDO {
        return countryMongoRepository.getByName(name).orElseThrow { ResourceNotFound("country with name $name not found") }
            .let { buildCountryDocument(it) }
    }

    private fun buildCountryDocument(countryDocument: CountryDocument): CountryDO {
        return CountryDO(countryDocument.id.toString(), countryDocument.name,
            countryDocument.description, countryDocument.shortVersion, countryDocument.createdAt)
    }
}