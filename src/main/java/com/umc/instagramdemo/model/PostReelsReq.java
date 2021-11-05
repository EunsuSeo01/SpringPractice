package com.umc.instagramdemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class PostReelsReq {
    private String userId;
    private String videoUrl;
    private String audioIdx;
}
