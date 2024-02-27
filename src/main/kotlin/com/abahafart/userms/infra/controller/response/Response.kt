package com.abahafart.userms.infra.controller.response

import java.time.Instant
import java.time.LocalDate

data class StatusResponse(val id: String, val description: String, val type: String,
                          val createdAt: Instant)
data class CountryResponse(val id: String, val name: String, val description: String,
                           val shortVersion: String, val createdAt: Instant)
data class AddressResponse(val id: String, val street: String, val number: String,
                           val neighborhood: String, val municipality: String, val state: String,
                           val zipCode: String, val country: CountryResponse,val createdAt: Instant)
data class PersonResponse(var id: String, val name: String, val surname: String, val fullName: String,
                    val birthDate: LocalDate, val addressList: MutableList<AddressResponse>,
                    var createdAt: Instant = Instant.now())
data class UserResponse(val id: String)