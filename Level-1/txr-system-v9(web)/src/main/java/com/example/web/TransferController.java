package com.example.web;

import com.example.service.TransferService;
import com.example.web.payload.TransferRequest;
import com.example.web.payload.TransferResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransferController {

    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/txr.htm"
    )
    public ModelAndView doTransfer(@ModelAttribute TransferRequest request) {
        transferService.transfer(request.getAmount(), request.getSourceAccountNumber(), request.getTargetAccountNumber());
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setMessage("transfer successful");
        //..
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("transferResponse",transferResponse);
        modelAndView.setViewName("txr-status");
        return modelAndView;
    }

}
