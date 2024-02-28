package com.abahafart.userms.domain.service.impl

import com.abahafart.userms.domain.model.CountryDO
import com.abahafart.userms.domain.model.StatusDO
import com.abahafart.userms.domain.repository.CountryRepository
import com.abahafart.userms.domain.repository.StatusRepository
import com.abahafart.userms.domain.service.CountryService
import com.abahafart.userms.domain.service.StatusService
import org.springframework.stereotype.Service

@Service
class StatusServiceImpl(val statusRepository: StatusRepository): StatusService {
    override fun create(statusDO: StatusDO) = statusRepository.saveStatus(statusDO)
    override fun getById(id: String) = statusRepository.getById(id)
}

@Service
class CountryServiceImpl(val countryRepository: CountryRepository): CountryService {
    override fun create(countryDO: CountryDO): CountryDO {
        return countryRepository.saveCountry(countryDO)
    }

    override fun getById(id: String): CountryDO {
        return countryRepository.getById(id)
    }

    override fun getByName(name: String): CountryDO {
        return countryRepository.getByName(name)
    }

}