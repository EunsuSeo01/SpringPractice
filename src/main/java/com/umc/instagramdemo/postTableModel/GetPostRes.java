package com.umc.instagramdemo.postTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GetPostRes {
    private int postIdx;
    private String userId;
    private String postImgUrl;
    private String content;
    private String status;
}
