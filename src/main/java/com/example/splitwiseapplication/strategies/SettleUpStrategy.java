package com.example.splitwiseapplication.strategies;

import com.example.splitwiseapplication.models.Expense;
import com.example.splitwiseapplication.utilities.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SettleUpStrategy {
    public List<Transaction> settleUp(List<Expense> expenses);
}
