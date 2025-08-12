package edu.miu.cs.cs425.srmwebapi.advice;

import edu.miu.cs.cs425.srmwebapi.error.ErrorResponse;
import edu.miu.cs.cs425.srmwebapi.exception.SupplierNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SRMWebAPIErrorHandler {

    @ExceptionHandler(SupplierNotFoundException.class)
    public ErrorResponse handleSupplierNotFoundException(SupplierNotFoundException e) {
        return new ErrorResponse(e.getMessage(), "11213");
    }

}
