package com.example.web;

import com.example.service.TransferService;
import com.example.web.payload.TransferRequest;
import com.example.web.payload.TransferResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {

    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/txr",
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    public /*@ResponseBody*/ TransferResponse doTransfer(@RequestBody TransferRequest request) {
        transferService.transfer(request.getAmount(), request.getSourceAccountNumber(), request.getTargetAccountNumber());
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setMessage("transfer successful");
        return transferResponse;
    }

}
