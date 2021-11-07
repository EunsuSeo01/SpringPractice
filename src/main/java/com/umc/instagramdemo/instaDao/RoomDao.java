package com.umc.instagramdemo.instaDao;

import com.umc.instagramdemo.roomTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class RoomDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetRoomRes> roomRes() {
        return this.jdbcTemplate.query("SELECT * FROM Room",
                (rs, rowNum) -> new GetRoomRes(
                        rs.getInt("roomIdx"),
                        rs.getString("roomName"),
                        rs.getString("roomImgUrl"),
                        rs.getString("status")
                )
        );
    }
}
