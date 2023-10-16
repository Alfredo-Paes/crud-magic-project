package br.com.alfredpaesdaluz.crudmagicproject.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class RequiredObjectsIsNullException : RuntimeException {
    constructor(): super("It is not allowed to persist a null object!")
    constructor(exception: String?): super(exception)
}