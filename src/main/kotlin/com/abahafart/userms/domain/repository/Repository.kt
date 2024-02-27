package com.abahafart.userms.domain.repository

import com.abahafart.userms.domain.model.*

interface StatusRepository {
    fun saveStatus(statusDO: StatusDO): StatusDO
    fun getById(id: String): StatusDO
}

interface CountryRepository {
    fun saveCountry(countryDO: CountryDO): CountryDO
    fun getById(id: String): CountryDO
    fun getByName(name: String): CountryDO
}

interface AddressRepository {
    fun saveAddress(addressDO: AddressDO): AddressDO
    fun getById(id: String): AddressDO
}

interface PersonRepository {
    fun savePerson(personDO: PersonDO): PersonDO
    fun getById(id: String): PersonDO
    fun getByFullName(fullName: String): PersonDO
}

interface UserRepository {
    fun saveUser(userDO: UserDO): UserDO
    fun getByEmail(email: String): UserDO
    fun getByUserName(userName: String): UserDO
    fun getByUserNameAndPassword(userName: String, password: String): UserDO
}