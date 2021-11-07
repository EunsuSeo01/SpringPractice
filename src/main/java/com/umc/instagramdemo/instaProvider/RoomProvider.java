package com.umc.instagramdemo.instaProvider;

import com.umc.instagramdemo.instaDao.RoomDao;
import com.umc.instagramdemo.roomTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomProvider {
    private final RoomDao roomDao;

    @Autowired
    public RoomProvider(RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    public List<GetRoomRes> getRoom() {
        return roomDao.roomRes();
    }
}
