package com.umc.instagramdemo.postTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor // setter, getter, 생성자를 자동 생성해줌.
public class PostPostReq {
    private String userId;
    private String postImgUrl;
    private String content;
}
