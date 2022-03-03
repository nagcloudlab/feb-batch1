package com.example.api;

import com.example.api.payload.TransferRequest;
import com.example.api.payload.TransferResponse;
import com.example.exception.AccountBalanceException;
import com.example.exception.AccountNotFoundException;
import com.example.service.TransferService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Scope("singleton")
@RequestMapping(
        value = "/api/transfer",
        consumes = {"application/json"},
        produces = {"application/json"}
)
public class TransferController {

    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<?> doTransfer(@RequestBody TransferRequest request) {
        transferService.transfer(request.getAmount(), request.getSourceAccountNum(), request.getTargetAccountNum());
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setMessage("transfer successful");
        return ResponseEntity.status(200).body(transferResponse);
    }


}
