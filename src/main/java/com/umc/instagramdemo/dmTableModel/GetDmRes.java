package com.umc.instagramdemo.dmTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetDmRes {
    private int msgIdx;
    private int roomIdx;
    private String msg;
    private String status;
}
