package com.umc.instagramdemo.instaProvider;

import com.umc.instagramdemo.instaDao.PostDao;
import com.umc.instagramdemo.postTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostProvider {
    private final PostDao postDao;

    @Autowired
    public PostProvider (PostDao postDao) {
        this.postDao = postDao;
    }

    public List<GetPostRes> getPost(String userId) {
        return postDao.postRes(userId);
    }

    public PostPostRes postPost(PostPostReq postPostReq) {
        int postIdx = postDao.addPost(postPostReq);
        return new PostPostRes(postIdx, 200, "OK");
    }
}
