package com.example.splitwiseapplication.command;

public interface Command {
    boolean matches(String input);
    void execute(String input);
}
