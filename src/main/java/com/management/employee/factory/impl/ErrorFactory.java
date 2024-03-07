package com.management.employee.factory.impl;

import com.management.employee.constant.ResposeConstant;
import com.management.employee.dto.ResponseDTO;
import com.management.employee.factory.interfaces.IResponseFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component("errorResponse")
public class ErrorFactory implements IResponseFactory {
    @Override
    public <T> ResponseEntity<ResponseDTO<T>> build(T data) {
        return ResponseEntity.internalServerError().body(
                ResponseDTO.<T>builder()
                        .status(HttpStatus.OK)
                        .message(ResposeConstant.SUCCESS_MESSAGE)
                        .data(data)
                        .build()
        );
    }

    @Override
    public <T> ResponseEntity<ResponseDTO<T>> custom(HttpStatus status, String message, T data) {
        return ResponseEntity.internalServerError().body(
                ResponseDTO.<T>builder()
                        .status(status)
                        .message(message)
                        .data(data)
                        .build()
        );
    }
}
