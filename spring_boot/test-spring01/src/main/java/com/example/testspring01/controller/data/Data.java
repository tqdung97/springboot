package com.example.testspring01.controller.data;

import com.example.testspring01.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Data {
    private List<UserDTO> userDTOS;
    private int currentPage;
    private int size;
    private int totalSize;
}
