package com.spearhead.nova.exception;

import javax.servlet.http.HttpServletRequest;

import com.spearhead.nova.model.ApiError;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomError implements ErrorController { 
    
    @RequestMapping("/error")
    @ResponseBody
    public ResponseEntity<Object> handleError(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        
        statusCode = statusCode != null ? statusCode : HttpStatus.INTERNAL_SERVER_ERROR.value();
        Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");
   
 
         ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,  exception == null? "Server Error": exception.getMessage(), exception);
         return buildResponseEntity(error);
    }


    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatuscode());
    }

    
}
