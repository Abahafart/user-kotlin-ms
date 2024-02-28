package com.abahafart.userms.infra.repository

import com.abahafart.userms.infra.repository.document.CountryDocument
import com.abahafart.userms.infra.repository.document.StatusDocument
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.Optional

interface StatusMongoRepository: MongoRepository<StatusDocument, String>{}
interface CountryMongoRepository: MongoRepository<CountryDocument, String>{
    fun getByName(name: String): Optional<CountryDocument>
}