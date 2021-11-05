package com.umc.instagramdemo.instaProvider;

import com.umc.instagramdemo.instaDao.ReelsDao;
import com.umc.instagramdemo.reelsTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelsProvider {
    private final ReelsDao reelsDao;

    @Autowired
    public ReelsProvider(ReelsDao reelsDao) {
        this.reelsDao = reelsDao;
    }

    public PostReelsRes postReels(PostReelsReq postReelsReq){
        int reelsIdx= reelsDao.addReels(postReelsReq);
        PostReelsRes postReelsRes = new PostReelsRes(reelsIdx);
        return postReelsRes;
    }

    public int putReels(PutReelsReq putReelsReq, int reelsIdx) {
        return reelsDao.putReels(putReelsReq, reelsIdx);
    }

    // 삭제된 릴스 정보 알려주기 위함.
    public List<DeleteReelsRes> getDeletedReels(int reelsIdx){
        List<DeleteReelsRes> reelsRes = reelsDao.reelsRes(reelsIdx);
        return reelsRes;
    }
    // 릴스 삭제를 위함.
    public void deleteReels(int reelsIdx){
        reelsDao.removeReels(reelsIdx);
    }
}
