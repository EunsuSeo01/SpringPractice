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

    public int putReels(PutReelsReq putReelsReq, int reelsIdx) {
        return userDao.putReels(putReelsReq, reelsIdx);
    }

    // 삭제된 릴스 정보 알려주기 위함.
    public List<DeleteReelsRes> getDeletedReels(int reelsIdx){
        List<DeleteReelsRes> reelsRes = userDao.reelsRes(reelsIdx);
        return reelsRes;
    }
    // 릴스 삭제를 위함.
    public void deleteReels(int reelsIdx){
        userDao.removeReels(reelsIdx);
    }
}
