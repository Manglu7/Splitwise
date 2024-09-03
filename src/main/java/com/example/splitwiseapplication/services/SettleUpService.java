package com.example.splitwiseapplication.services;

import com.example.splitwiseapplication.models.Expense;
import com.example.splitwiseapplication.models.Group;
import com.example.splitwiseapplication.repos.ExpenseRepo;
import com.example.splitwiseapplication.repos.GroupRepo;
import com.example.splitwiseapplication.strategies.SettleUpStrategy;
import com.example.splitwiseapplication.utilities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {
    private GroupRepo groupRepo;
    private ExpenseRepo expenseRepo;
    private SettleUpStrategy settleUpStrategy;
    @Autowired
    SettleUpService(GroupRepo groupRepo, ExpenseRepo expenseRepo,
                    SettleUpStrategy settleUpStrategy) {
        this.groupRepo = groupRepo;
        this.expenseRepo = expenseRepo;
        this.settleUpStrategy = settleUpStrategy;
    }
    public List<Transaction> settleUpUser(Long user_id){
        return null;
    }

    public List<Transaction> settleUpGroup(Long group_id){
        Optional<Group> groupOptional = groupRepo.findById(group_id);
        if(groupOptional.isEmpty()){
            throw new RuntimeException("Group does not exist");
        }
        Group group = groupOptional.get();
        List<Expense> expenses = expenseRepo.findAllByGroup(group);
        return settleUpStrategy.settleUp(expenses);
    }
}
