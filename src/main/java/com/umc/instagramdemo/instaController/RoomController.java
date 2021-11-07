package com.umc.instagramdemo.instaController;

import com.umc.instagramdemo.instaProvider.RoomProvider;
import com.umc.instagramdemo.roomTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    private RoomProvider roomProvider;

    @Autowired
    public RoomController(RoomProvider roomProvider) {
        this.roomProvider = roomProvider;
    }

    // GET : (DM을 보낼 수 있는) 이미 만들어져있는 방의 개수가 몇개인지
    @GetMapping("/rooms")
    public List<GetRoomRes> getRoom() {
        return roomProvider.getRoom();
    }
}
