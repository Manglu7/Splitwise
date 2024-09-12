package com.example.splitwiseapplication.command;

import com.example.splitwiseapplication.Dto.ResponseStatus;
import com.example.splitwiseapplication.Dto.SettleUpGroupRequestDto;
import com.example.splitwiseapplication.Dto.SettleUpGroupResponseDto;
import com.example.splitwiseapplication.controller.SettleUpController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SettleUpGroupCommand implements Command {
    @Autowired
    private SettleUpController settleUpController;
    @Override
    public boolean matches(String input) {
        List<String> words = List.of(input.split(" "));
        return words.size() < 2 && words.getFirst().equals("SettleUpGroup");
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long groupId = Long.valueOf(words.get(1));
        SettleUpGroupRequestDto request = new SettleUpGroupRequestDto();
        request.setGroupId(groupId);
        SettleUpGroupResponseDto response = settleUpController.settleUpGroup(request);
        System.out.println(response.getResponseStatus());
        if(response.getResponseStatus().equals(ResponseStatus.FAILURE)){
            System.out.println(response.getResponseMessage());
        }

    }
}
