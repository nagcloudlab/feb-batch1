package com.example;

import com.example.service.TransferService;

public class TransferServiceApplication {
    public static void main(String[] args) {

        //----------------------------------------------
        // init / boot
        //----------------------------------------------

        TransferService transferService=new TransferService();

        //----------------------------------------------
        // Use
        //----------------------------------------------

        transferService.transfer(100.00,"1","2");
        transferService.transfer(200.00,"1","2");

        //----------------------------------------------
        // destroy
        //----------------------------------------------

        //.....


    }

}
