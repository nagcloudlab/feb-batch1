package com.example.api;

import com.example.api.payload.TransferResponse;
import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvicer {


    @ExceptionHandler(
            value = AccountNotFoundException.class
    )
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> notFoundHandler(Throwable t) {
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setMessage(t.getMessage());
        return ResponseEntity.status(404).body(transferResponse);
    }

    @ExceptionHandler(
            value = AccountBalanceException.class
    )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> balanceException(Throwable t) {
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setMessage(t.getMessage());
        return ResponseEntity.status(400).body(transferResponse);
    }

}
