package com.umc.instagramdemo;

import com.umc.instagramdemo.postTableModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PostDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int addPost(PostPostReq postPostReq) {
        String createPostQuery = "INSERT INTO Post (userId, postImgUrl, content) VALUES (?,?,?)";
        Object[] createPostParam = new Object[] {
                postPostReq.getUserId(), postPostReq.getPostImgUrl(), postPostReq.getContent()
        };
        this.jdbcTemplate.update(createPostQuery, createPostParam);

        return this.jdbcTemplate.queryForObject("SELECT last_insert_id()", int.class);
    }
}
