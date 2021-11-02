package com.umc.instagramdemo;

import com.umc.instagramdemo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProvider {
    private final UserDao userDao;

    @Autowired
    public UserProvider(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<GetUserRes> getUser(){
        List<GetUserRes> userRes = userDao.userRes();
        return userRes;
    }

    public PostUserRes postUser(PostUserReq postUserReq){
        int personIdx= userDao.addUser(postUserReq);
        PostUserRes postUserRes = new PostUserRes(personIdx);
        return postUserRes;
    }
    public List<DeleteReelsRes> getDeletedReels(int reelsIdx){
        List<DeleteReelsRes> reelsRes = userDao.reelsRes(reelsIdx);

        return reelsRes;
    }

    public void deleteReels(int reelsIdx){
        userDao.removeReels(reelsIdx);
    }
}