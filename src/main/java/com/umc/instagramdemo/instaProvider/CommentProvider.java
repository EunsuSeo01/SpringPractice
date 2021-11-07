package com.umc.instagramdemo.instaProvider;

import com.umc.instagramdemo.instaDao.CommentDao;
import com.umc.instagramdemo.commentTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentProvider {
    private final CommentDao cmtDao;

    @Autowired
    public CommentProvider(CommentDao cmtDao) {
        this.cmtDao = cmtDao;
    }

    // GET
    public List<GetCommentRes> getComment(int postIdx) {
        return cmtDao.cmtRes(postIdx);
    }

    // POST
    public PostCommentRes postComment(PostCommentReq postCmtReq, int postIdx) {
        return cmtDao.addComment(postCmtReq, postIdx);
    }
}
