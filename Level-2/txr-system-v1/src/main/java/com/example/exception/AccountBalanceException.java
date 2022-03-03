package com.example.exception;

public class AccountBalanceException extends Throwable {
    public AccountBalanceException(String s) {
        super(s);
    }
}
