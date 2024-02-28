package com.abahafart.userms.domain.service

import com.abahafart.userms.domain.model.CountryDO
import com.abahafart.userms.domain.model.StatusDO

interface StatusService {
    fun create(statusDO: StatusDO): StatusDO
    fun getById(id: String): StatusDO
}

interface CountryService {
    fun create(countryDO: CountryDO): CountryDO
    fun getById(id: String): CountryDO
    fun getByName(name: String): CountryDO
}