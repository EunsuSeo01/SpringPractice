package com.umc.instagramdemo.commentTableModel;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@Setter
@Getter
public class PostCommentRes {
    private int cmtIdx;     // POST도 리소스에 대한 표현을 반환하는 게 좋다.
}
