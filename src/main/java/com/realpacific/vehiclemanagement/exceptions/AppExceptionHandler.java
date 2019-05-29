package com.realpacific.vehiclemanagement.exceptions;

import com.realpacific.vehiclemanagement.entities.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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


}
