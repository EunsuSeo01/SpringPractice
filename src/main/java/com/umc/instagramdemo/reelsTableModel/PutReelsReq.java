package com.umc.instagramdemo.reelsTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PutReelsReq {
    private String userId;
    private String videoUrl;
    private int audioIdx;
}
