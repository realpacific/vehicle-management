package com.realpacific.vehiclemanagement.exceptions;

import com.realpacific.vehiclemanagement.entities.BaseResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestController
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleUnsupportedException(Exception e, WebRequest request) {
        BaseResponse<String> response = new BaseResponse<>(null, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<Object> handleTransactionNotFound(Exception e, WebRequest request) {
        BaseResponse<String> response = new BaseResponse<>(null, e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<Object> handleDataIntegrityViolation(Exception e, WebRequest request) {
        BaseResponse response = new BaseResponse<>(null, "Duplicate fields.");
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(BadInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected BaseResponse handleBadInputException(Exception e, WebRequest request) {
        BaseResponse response = new BaseResponse<>(null, e.getMessage());
        return response;
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            // String fieldName = ((FieldError) error).getField();
            errors.add(error.getDefaultMessage());
        });

        BaseResponse response = new BaseResponse<String>(null, errors.toString());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
