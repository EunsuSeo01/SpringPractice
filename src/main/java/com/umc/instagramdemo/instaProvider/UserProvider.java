package com.umc.instagramdemo.instaProvider;

import com.umc.instagramdemo.instaDao.UserDao;
import com.umc.instagramdemo.personTableModel.*;
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

}
