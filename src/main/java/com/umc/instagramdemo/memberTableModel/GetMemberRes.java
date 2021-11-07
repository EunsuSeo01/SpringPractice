package com.umc.instagramdemo.memberTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetMemberRes {
    private int memberIdx;
    private int roomIdx;
    private String memberId;
    private String status;
}
