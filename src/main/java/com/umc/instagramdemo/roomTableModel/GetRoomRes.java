package com.umc.instagramdemo.roomTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetRoomRes {
    private int roomIdx;
    private String roomName;
    private String roomImgUrl;
    private String status;
}
