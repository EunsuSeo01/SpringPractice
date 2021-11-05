package com.umc.instagramdemo.instaController;

import com.umc.instagramdemo.instaProvider.PostProvider;
import com.umc.instagramdemo.postTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private PostProvider postProv;

    @Autowired
    public PostController(PostProvider postProv) {
        this.postProv = postProv;       // 초기화.
    }

    @GetMapping("/post/{userId}")  // 해당 아이디를 가진 유저의 게시물을 조회하는 것이니까.
    public List<GetPostRes> getPost(@PathVariable String userId) {
        return postProv.getPost(userId);
    }

    @ResponseBody
    @PostMapping("/post")
    public PostPostRes postPost(@RequestBody PostPostReq postPostReq) {
        return postProv.postPost(postPostReq);
    }
}
