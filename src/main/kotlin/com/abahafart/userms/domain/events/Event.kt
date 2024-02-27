package com.abahafart.userms.domain.events

import com.abahafart.userms.domain.model.*

interface Event {
    fun statusEvent(statusDO: StatusDO)
    fun countryEvent(countryDO: CountryDO)
    fun addressEvent(addressDO: AddressDO)
    fun personEvent(personDO: PersonDO)
    fun userEvent(userDO: UserDO)
}