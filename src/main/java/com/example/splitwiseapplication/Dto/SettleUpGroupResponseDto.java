package com.example.splitwiseapplication.Dto;

import com.example.splitwiseapplication.utilities.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpGroupResponseDto {
    private ResponseStatus responseStatus;
    private String responseMessage;
    private List<Transaction> transactions;
}
