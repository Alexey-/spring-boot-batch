package com.sebbia.batch.web;

import com.sebbia.batch.response.ErrorResponse;
import com.sebbia.batch.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    private Log logger = LogFactory.getLog(getClass());

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> generalError(Exception exception) {
        logger.error("Server failed to parse request", exception);
        return new ResponseEntity<Response>(new ErrorResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
