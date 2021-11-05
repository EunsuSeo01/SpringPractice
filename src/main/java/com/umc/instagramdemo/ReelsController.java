package com.umc.instagramdemo;

import com.umc.instagramdemo.reelsTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReelsController {

    private ReelsProvider reelsProvider;

    @Autowired
    public ReelsController(ReelsProvider reelsProvider) {
        this.reelsProvider = reelsProvider;
    }

    @ResponseBody
    @PostMapping("/reels")
    public PostReelsRes postUser(@RequestBody PostReelsReq postReelsReq){   // 요청을 받아서 처리.
        PostReelsRes postReelsRes = reelsProvider.postReels(postReelsReq);
        return postReelsRes;    // 응답
    }

    @PutMapping("/reels/{reelsIdx}")
    public int putReels(@RequestBody PutReelsReq putReelsReq, @PathVariable int reelsIdx) {
        return reelsProvider.putReels(putReelsReq, reelsIdx);
    }

    @DeleteMapping("/reels/{reelsIdx}")
    public List<DeleteReelsRes> removeReels(@PathVariable int reelsIdx) {
        List<DeleteReelsRes> reelsRes = reelsProvider.getDeletedReels(reelsIdx);
        reelsProvider.deleteReels(reelsIdx);
        return reelsRes;
    }
}
