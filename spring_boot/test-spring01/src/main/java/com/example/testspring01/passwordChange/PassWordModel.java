package com.example.testspring01.passwordChange;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PassWordModel {
    private String oldPassword;
    private String newPassword;
}
