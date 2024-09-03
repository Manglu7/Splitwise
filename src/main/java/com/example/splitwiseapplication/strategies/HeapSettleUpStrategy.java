package com.example.splitwiseapplication.strategies;

import com.example.splitwiseapplication.models.Expense;
import com.example.splitwiseapplication.utilities.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;


public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUp(List<Expense> expenses){

        return List.of();
    }
}
