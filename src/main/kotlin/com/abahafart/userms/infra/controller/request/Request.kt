package com.abahafart.userms.infra.controller.request

import java.time.LocalDate

data class StatusRequest(val description: String, val type: String)
data class CountryRequest(val name: String, val description: String, val shortVersion: String)
data class AddressRequest(val street: String, val number: String, val neighborhood: String, val municipality: String, val state: String, val zipCode: String, val country: CountryRequest)
data class PersonRequest(val name: String, val surname: String, val fullName: String, val birthDate: LocalDate, val address: AddressRequest)
data class UserRequest(val userName: String, val password: String, val email: String, val person: PersonRequest)