package com.umc.instagramdemo.instaProvider;

import com.umc.instagramdemo.instaDao.HeartDao;
import com.umc.instagramdemo.heartTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeartProvider {
    private final HeartDao heartDao;

    public HeartProvider(HeartDao heartDao) {
        this.heartDao = heartDao;
    }

    // GET
    public List<GetHeartRes> getHeart(int postIdx) {
        return heartDao.heartRes(postIdx);
    }

    // POST
    public PostHeartRes postHeart(PostHeartReq postHeartReq) {
        return heartDao.addHeart(postHeartReq);
    }
}
