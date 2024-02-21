package com.abahafart.userms.infra.repository

import com.abahafart.userms.infra.repository.document.StatusDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface StatusMongoRepository: MongoRepository<StatusDocument, String>{}