package com.umc.instagramdemo.personTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GetUserRes {
    private int personIdx;
    private String phoneNumber;
    private String gender;
    private String birth;
}