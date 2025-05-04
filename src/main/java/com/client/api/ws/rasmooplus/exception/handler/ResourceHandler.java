package com.client.api.ws.rasmooplus.exception.handler;

import com.client.api.ws.rasmooplus.dto.error.ErrorResponseDTO;
import com.client.api.ws.rasmooplus.exception.BadRequestException;
import com.client.api.ws.rasmooplus.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResourceHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> notFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponseDTO.builder().
                message(e.getMessage()).status(HttpStatus.NOT_FOUND).code(HttpStatus.NOT_FOUND.value()).build());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> badRequestException(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorResponseDTO.builder().
                message(e.getMessage()).status(HttpStatus.BAD_REQUEST).code(HttpStatus.BAD_REQUEST.value()).build());
    }
}
