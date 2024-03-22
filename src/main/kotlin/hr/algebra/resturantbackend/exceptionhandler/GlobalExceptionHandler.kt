
package hr.algebra.resturantbackend.exceptionhandler

import hr.algebra.resturantbackend.exception.EntityAlreadyExists
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException::class)
    fun handleEntityNotFound(e: EntityNotFoundException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(EntityAlreadyExists::class)
    fun handleEntityAlreadyExists(e: EntityAlreadyExists): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.CONFLICT)
}