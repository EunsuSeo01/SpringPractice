package com.umc.instagramdemo.instaController;

import com.umc.instagramdemo.instaProvider.CommentProvider;
import com.umc.instagramdemo.commentTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    private CommentProvider cmtProv;

    @Autowired
    public CommentController(CommentProvider cmtProv) {
        this.cmtProv = cmtProv;
    }

    // GET : 게시물의 댓글 조회.
    @GetMapping("/comments/{postIdx}")   // 특정 게시물의 댓글 조회.
    public List<GetCommentRes> getComment(@PathVariable int postIdx) {
        return cmtProv.getComment(postIdx);
    }

    // POST : 게시물에 댓글 달기.
    @PostMapping("/comments/{postIdx}")
    public PostCommentRes postComment(@RequestBody PostCommentReq postCmtReq, @PathVariable int postIdx) {
        return cmtProv.postComment(postCmtReq, postIdx);
    }
}
