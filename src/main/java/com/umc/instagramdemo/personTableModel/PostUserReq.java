package com.umc.instagramdemo.reelsTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PostUserReq {
    private String phoneNumber;
    private String gender;
    private String birth;
}