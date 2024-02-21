package com.abahafart.userms.infra.controller

import com.abahafart.userms.domain.exceptions.ResourceNotFound
import jakarta.servlet.http.HttpServletRequest
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class RestExceptionHandler {

    data class ErrorMessage(val httpStatus: Int, val message: String)

    private val logger = KotlinLogging.logger {}

    @ExceptionHandler(ResourceNotFound::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun notFoundResourceException(resourceNotFound: ResourceNotFound, request: HttpServletRequest): ResponseEntity<ErrorMessage> {
        logger.info { resourceNotFound.message }
        val errorMessage = ErrorMessage(HttpStatus.NOT_FOUND.value(), resourceNotFound.message)
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }
}