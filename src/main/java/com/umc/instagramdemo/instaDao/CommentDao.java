package com.umc.instagramdemo.instaDao;


import com.umc.instagramdemo.commentTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CommentDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetCommentRes> cmtRes(int postIdx) {
        return this.jdbcTemplate.query("SELECT * FROM Comment WHERE postIdx = ?",
                (rs, rowNum) -> new GetCommentRes(
                        rs.getInt("cmtIdx"),
                        rs.getInt("postIdx"),
                        rs.getString("cmtUserId"),
                        rs.getString("comment"),
                        rs.getString("status")
                ), postIdx);
    }
}
