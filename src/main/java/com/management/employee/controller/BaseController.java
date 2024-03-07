package com.management.employee.controller;

import com.management.employee.dto.ResponseDTO;
import com.management.employee.factory.interfaces.IResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    @Autowired
    @Qualifier("successResponse")
    private IResponseFactory successFactory;
    @Autowired
    @Qualifier("errorResponse")
    private IResponseFactory errorFactory;

    public <T> ResponseEntity<ResponseDTO<T>> success(T data){
        return successFactory.build(data);
    }
    public <T> ResponseEntity<ResponseDTO<T>> error(T data){
        return errorFactory.build(data);
    }
}
