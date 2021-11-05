package com.umc.instagramdemo;

import com.umc.instagramdemo.postTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    private PostProvider postProv;

    @Autowired
    public PostController(PostProvider postProv) {
        this.postProv = postProv;       // 초기화.
    }

    @ResponseBody
    @PostMapping("/post")
    public PostPostRes postPost(@RequestBody PostPostReq postPostReq) {
        return postProv.postPost(postPostReq);
    }
}
