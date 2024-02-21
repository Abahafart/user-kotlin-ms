package com.abahafart.userms.infra.repository.document

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collation = "status")
data class StatusDocument(@Id val id: ObjectId = ObjectId.get(), val description: String, val type: String, val createdAt: Instant = Instant.now())