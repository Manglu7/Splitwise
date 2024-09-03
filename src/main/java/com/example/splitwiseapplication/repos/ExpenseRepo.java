package com.example.splitwiseapplication.repos;

import com.example.splitwiseapplication.models.Expense;
import com.example.splitwiseapplication.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {
    List<Expense> findAllByGroup(Group group);
}
