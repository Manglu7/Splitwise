package com.example.splitwiseapplication;

import com.example.splitwiseapplication.command.CommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
	private Scanner scanner = new Scanner(System.in);
	@Autowired
	private CommandExecutor commandExecutor;
	@Override
	public void run(String... args) throws Exception {
		while(true){
			String input = scanner.nextLine();
			commandExecutor.execute(input);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

}
