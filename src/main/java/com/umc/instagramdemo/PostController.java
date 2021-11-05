package com.umc.instagramdemo;

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

    @GetMapping("/post")
    public List<GetPostRes> getPost() {
        return postProv.getPost();
    }

    @ResponseBody
    @PostMapping("/post")
    public PostPostRes postPost(@RequestBody PostPostReq postPostReq) {
        return postProv.postPost(postPostReq);
    }
}
