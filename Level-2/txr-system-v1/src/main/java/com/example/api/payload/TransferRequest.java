package com.example.api.payload;


import lombok.Data;

@Data
public class TransferRequest {
    private double amount;
    private String sourceAccountNum;
    private String targetAccountNum;
}
