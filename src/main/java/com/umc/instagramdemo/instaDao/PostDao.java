package com.umc.instagramdemo.instaDao;

import com.umc.instagramdemo.postTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class PostDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // GET
    public List<GetPostRes> postRes(String userId) {
        return this.jdbcTemplate.query("SELECT * FROM Post WHERE userId = ?",
                (rs, rowNum) -> new GetPostRes(
                        rs.getInt("postIdx"),
                        rs.getString("userId"),
                        rs.getString("postImgUrl"),
                        rs.getString("content"),
                        rs.getString("status")
                ),
                userId);
    }

    // GET
    public GetPostRes getOneRes(String userId, int postIdx) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM Post WHERE userId = ? AND postIdx = ?",
                (rs, rowNum) -> new GetPostRes(
                        rs.getInt("postIdx"),
                        rs.getString("userId"),
                        rs.getString("postImgUrl"),
                        rs.getString("content"),
                        rs.getString("status")
                ),
                userId, postIdx);
    }

    // POST
    public int addPost(PostPostReq postPostReq) {
        String createPostQuery = "INSERT INTO Post (userId, postImgUrl, content) VALUES (?,?,?)";
        Object[] createPostParam = new Object[] {
                postPostReq.getUserId(), postPostReq.getPostImgUrl(), postPostReq.getContent()
        };
        this.jdbcTemplate.update(createPostQuery, createPostParam);

        return this.jdbcTemplate.queryForObject("SELECT last_insert_id()", int.class);
    }
}
