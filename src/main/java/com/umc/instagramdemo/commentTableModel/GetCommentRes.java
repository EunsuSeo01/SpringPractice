package com.umc.instagramdemo.commentTableModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GetCommentRes {
    private int cmtIdx;
    private int postIdx;
    private String cmtUserId;
    private String comment;
    private String status;
}
