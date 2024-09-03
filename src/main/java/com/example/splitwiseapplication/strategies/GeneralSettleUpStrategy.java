package com.example.splitwiseapplication.strategies;

import com.example.splitwiseapplication.models.Expense;
import com.example.splitwiseapplication.models.User;
import com.example.splitwiseapplication.models.UserExpense;
import com.example.splitwiseapplication.utilities.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

@Component
public class GeneralSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expenses){
        HashMap<User, Integer> expensesMap = new HashMap<>();
        for (Expense expense : expenses) {
            for (UserExpense expenseUser : expense.getUserExpenses()) {
                if (expensesMap.containsKey(expenseUser.getUser())) {
                    expensesMap.put(expenseUser.getUser(), expensesMap.get(expenseUser.getUser()) + expenseUser.getAmount());
                } else {
                    expensesMap.put(expenseUser.getUser(), expenseUser.getAmount());
                }
            }
        }
        List<Transaction> transactions = new ArrayList<>();
        for(User user : expensesMap.keySet()) {
            System.out.println(user.getName() + " " + expensesMap.get(user));
        }
        List<User> userList = new ArrayList<>(expensesMap.keySet());
        int size = userList.size();
        for(int i = 0; i < size - 1; i ++) {
            Transaction transaction = new Transaction();
            if(expensesMap.get(userList.get(i)) < 0) {
                transaction.setUserFrom(userList.get(i));
                transaction.setAmount(Math.abs(expensesMap.get(userList.get(i))));
                transaction.setUserTo(userList.get(i+1));
                transactions.add(transaction);
//                expensesMap.remove(userList.get(i));
                expensesMap.put(userList.get(i + 1), expensesMap.get(userList.get(i + 1)) + expensesMap.get(userList.get(i)));
            } else if(expensesMap.get(userList.get(i)) > 0) {
                transaction.setUserFrom(userList.get(i + 1));
                transaction.setAmount(Math.abs(expensesMap.get(userList.get(i))));
                transaction.setUserTo(userList.get(i));
                transactions.add(transaction);
//                expensesMap.remove(userList.get(i));
                expensesMap.put(userList.get(i + 1), expensesMap.get(userList.get(i + 1)) + expensesMap.get(userList.get(i)));
            }
        }
        return transactions;
    }
}
