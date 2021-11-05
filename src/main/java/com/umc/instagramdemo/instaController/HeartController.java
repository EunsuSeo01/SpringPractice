package com.umc.instagramdemo.instaController;

import com.umc.instagramdemo.instaProvider.HeartProvider;
import com.umc.instagramdemo.heartTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeartController {
    HeartProvider heartProv;

    public HeartController(HeartProvider heartProv) {
        this.heartProv = heartProv;
    }

    // GET
    @GetMapping("/heart/{postIdx}") // 특정 게시물의 하트를 확인하는 것이니까.
    public List<GetHeartRes> getHeart(@PathVariable int postIdx){
        return heartProv.getHeart(postIdx);
    }
}
