package com.umc.instagramdemo;

import com.umc.instagramdemo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserProvider userProvider;

    @Autowired
    public UserController(UserProvider userProvider) {
        this.userProvider = userProvider;
    }

    @GetMapping("/users")
    public List<GetUserRes> getUser(){
        List<GetUserRes> userRes = userProvider.getUser();
        return userRes;
    }

    @ResponseBody
    @PostMapping("/users")
    public PostUserRes postUser(@RequestBody PostUserReq postUserReq){
        PostUserRes postUserRes = userProvider.postUser(postUserReq);
        return postUserRes;
    }

    @DeleteMapping("/reels/{reelsIdx}")
    public List<DeleteReelsRes> removeReels(@PathVariable int reelsIdx) {
        List<DeleteReelsRes> reelsRes = userProvider.getDeletedReels(reelsIdx);
        userProvider.deleteReels(reelsIdx);
        return reelsRes;
    }

}
