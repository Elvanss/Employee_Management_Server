package com.management.employee.exception;

import com.management.employee.dto.ResponseDTO;
import com.management.employee.factory.interfaces.IResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {
    @Autowired
    @Qualifier("errorResponse")
    private  IResponseFactory errorFactory;


    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ResponseDTO<Void>> handleException(AccountException e) {
//        return ResponseEntity.internalServerError().body(
//                ResponseDTO.<Void>builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(e.getMessage()).build()
//        );
        return errorFactory.custom(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
    }
}
