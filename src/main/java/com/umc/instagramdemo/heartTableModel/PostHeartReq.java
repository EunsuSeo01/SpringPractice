package com.umc.instagramdemo.heartTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostHeartReq {     // 하트 생성 요청 -> 유저가 어떤 유저의 게시물에 하트를 눌렀다는 것.
    private int postIdx;
    private String heartUserId;
}
