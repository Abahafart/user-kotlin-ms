package com.abahafart.userms.infra.repository.document

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "status")
data class StatusDocument(@Id val id: ObjectId = ObjectId.get(), val description: String, val type: String, val createdAt: Instant = Instant.now())
@Document(collection = "country")
data class CountryDocument(@Id val id: ObjectId = ObjectId.get(), val name: String, val description: String,
                     val shortVersion: String, var createdAt: Instant = Instant.now())