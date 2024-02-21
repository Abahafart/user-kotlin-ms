package com.abahafart.userms.domain.repository

import com.abahafart.userms.domain.model.Status

interface StatusRepository {
    fun saveStatus(status: Status): Status
    fun getById(id: String): Status
}