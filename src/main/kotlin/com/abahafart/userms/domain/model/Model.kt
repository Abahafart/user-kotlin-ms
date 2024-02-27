package com.abahafart.userms.domain.model

import java.time.Instant
import java.time.LocalDate

data class StatusDO(var id: String = "", var description: String, var type: String,
                    var createdAt: Instant = Instant.now())
data class CountryDO(var id: String = "", val name: String, val description: String,
                     val shortVersion: String, var createdAt: Instant = Instant.now())
data class AddressDO(var id: String = "", val street: String, val number: String,
                     val neighborhood: String, val municipality: String, val state: String,
                     val zipCode: String, val country: CountryDO,
                     var createdAt: Instant = Instant.now())
data class PersonDO(var id: String = "", val name: String, val surname: String, val fullName: String,
                    val birthDate: LocalDate, val addressList: MutableList<AddressDO>,
                    var createdAt: Instant = Instant.now())
data class UserDO(var id: String = "", val userName: String, val password: String, val email: String,
                  val person: PersonDO, var createdAt: Instant = Instant.now())