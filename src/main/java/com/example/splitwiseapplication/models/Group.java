package com.example.splitwiseapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "user_groups")
public class Group extends BaseModel {
    private String name;
    @ManyToOne
    private User admin;
    @ManyToMany
    private List<User> users;
    @OneToMany(mappedBy = "group")
    private List<Expense> expenses;
}
