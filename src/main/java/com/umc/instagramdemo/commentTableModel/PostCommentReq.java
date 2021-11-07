package com.umc.instagramdemo.commentTableModel;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@Setter
@Getter
public class PostCommentReq {
    private int postIdx;
    private String cmtUserId;
    private String comment;
}
