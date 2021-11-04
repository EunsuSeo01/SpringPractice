package com.umc.instagramdemo.model;

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
