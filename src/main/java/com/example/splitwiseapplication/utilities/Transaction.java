package com.example.splitwiseapplication.utilities;

import com.example.splitwiseapplication.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private User userFrom;
    private User userTo;
    private int amount;
}
