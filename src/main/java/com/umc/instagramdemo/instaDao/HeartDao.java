package com.umc.instagramdemo.instaDao;

import com.umc.instagramdemo.heartTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class HeartDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // GET
    public List<GetHeartRes> heartRes(int postIdx) {
        return this.jdbcTemplate.query("SELECT * FROM Heart WHERE postIdx = ?",
                (rs, rowNum) -> new GetHeartRes(
                        rs.getInt("heartIdx"),
                        rs.getInt("postIdx"),
                        rs.getString("heartUserId"),
                        rs.getString("status")),
                postIdx);
    }
}
