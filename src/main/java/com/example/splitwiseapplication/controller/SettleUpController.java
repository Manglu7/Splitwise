package com.example.splitwiseapplication.controller;

import com.example.splitwiseapplication.Dto.*;
import com.example.splitwiseapplication.services.SettleUpService;
import com.example.splitwiseapplication.utilities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    @Autowired
    SettleUpService settleUpService;
    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto request) {
        SettleUpUserResponseDto response = new SettleUpUserResponseDto();
        try {
            List<Transaction> transactions = settleUpService.settleUpUser(request.getUserId());
            response.setTransactions(transactions);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
          }

        return response;
    }

    public SettleUpGroupResponseDto settleUpGroup(SettleUpGroupRequestDto request) {
        SettleUpGroupResponseDto response = new SettleUpGroupResponseDto();
        try{
            List<Transaction> transactions = settleUpService.settleUpGroup(request.getGroupId());
            response.setTransactions(transactions);
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(Exception ex){
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setResponseMessage(ex.getMessage());
        }
        return response;
    }

}
