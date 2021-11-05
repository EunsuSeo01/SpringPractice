package com.umc.instagramdemo.postTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PostPostRes {
    private int postIdx;
    private int resCode;
    private String resContent;
}
